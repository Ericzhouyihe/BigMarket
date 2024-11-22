package com.zhouyihe.bigmarket.domain.strategy.service.armory;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyRuleEntity;
import com.zhouyihe.bigmarket.domain.strategy.repository.IStrategyRepository;
import com.zhouyihe.bigmarket.types.common.Constants;
import com.zhouyihe.bigmarket.types.enums.ResponseCode;
import com.zhouyihe.bigmarket.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.*;

/**
 * @ClassName StrategyArmory
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/7
 * @description: 策略装配库(兵工厂)，负责初始化策略计算
 */
@Slf4j
@Service
public class StrategyArmoryDispatch implements IStrategyArmory, IStrategyDispatch {
    
    @Resource
    private IStrategyRepository repository;
    
    /**
     * 装配抽奖策略配置「触发的时机可以为活动审核通过后进行调用」
     *
     * @param strategyId 策略ID
     * @return 装配结果
     */
    @Override
    public boolean assembleLotteryStrategy(Long strategyId) {
        // 1. 查询策略配置
        // 装配 策略id 对应的 奖品列表
        List<StrategyAwardEntity> strategyAwardEntities = repository.queryStrategyAwardList(strategyId);
        
        // 2. 缓存奖品的库存总数量[用于decr扣减库存使用]
        for (StrategyAwardEntity strategyAwardEntity : strategyAwardEntities) {
            Integer awardId = strategyAwardEntity.getAwardId();
            Integer awardCount = strategyAwardEntity.getAwardCount();
            // 缓存起来
            cacheStrategyAwardCount(strategyId, awardId, awardCount);
        }
        
        // 3.1 默认装配配置[全量抽奖概率]
        assembleLotteryStrategy(String.valueOf(strategyId), strategyAwardEntities);
        
        // 3.2 rule_weight 权重策略配置,配置了rule_weight则需要配置,就是积分等级划分的规则 到4000,6000积分等级可抽到的奖品范围不同
        // 从strategy表中查出strategyId对应的策略的基本信息,策略下配置的规则模型
        StrategyEntity strategyEntity = repository.queryStrategyEntityByStrategyId(strategyId);
        // 策略的规则模型ruleModels中若配置了ruleWeight,这里就会返回"ruleWeight",否则返回null
        String ruleWeight = strategyEntity.getRuleWeight();
        // 当RuleWeight中没有rule_weight类型时,直接返回true -- 策略配置完成
        if (null == ruleWeight) return true;
        
        // 获取抽奖规则类型为rule_weight的抽奖规则
        StrategyRuleEntity strategyRuleEntity = repository.queryStrategyRule(strategyId, ruleWeight);
        
        // 查询结果为空,抛出异常
        if (null == strategyRuleEntity) {
            throw new AppException(ResponseCode.STRATEGY_RULE_WEIGHT_IS_NULL.getCode(),
                    ResponseCode.STRATEGY_RULE_WEIGHT_IS_NULL.getInfo());
        }
        
        // 获取权重值
        Map<String, List<Integer>> ruleWeightValueMap = strategyRuleEntity.getRuleWeightValues();
        // 将所有的键(配置规则里的积分等级--到达某一个积分等级之后会新增可以抽到的奖品)存储成一个Set集合--积分等级的集合
        Set<String> pointLevels = ruleWeightValueMap.keySet();
        for (String pointLevel : pointLevels) {
            List<Integer> ruleWeightValues = ruleWeightValueMap.get(pointLevel);
            // 克隆strategyAwardEntities
            ArrayList<StrategyAwardEntity> strategyAwardEntitiesClone = new ArrayList<>(strategyAwardEntities);
            strategyAwardEntitiesClone.removeIf(entity -> !ruleWeightValues.contains(entity.getAwardId()));
            
            // strategyId_key List<Integer>
            assembleLotteryStrategy(String.valueOf(strategyId)
                    .concat(Constants.UNDERLINE)
                    .concat(pointLevel), strategyAwardEntitiesClone);
        }
        
        return true;
    }
    
    /**
     * 缓存
     *
     * @param strategyId
     * @param awardId
     * @param awardCount
     */
    private void cacheStrategyAwardCount(Long strategyId, Integer awardId, Integer awardCount) {
        String cacheKey = Constants.RedisKey.STRATEGY_AWARD_COUNT_KEY + Constants.UNDERLINE + awardId;
        repository.cacheStrategyAwardCount(cacheKey, awardCount);
    }
    
    
    /**
     * 计算公式；
     * 1. 找到范围内最小的概率值，比如 0.1、0.02、0.003，需要找到的值是 0.003
     * 2. 基于1找到的最小值，0.003 就可以计算出百分比、千分比的整数值。这里就是1000
     * 3. 那么「概率 * 1000」分别占比100个、20个、3个，总计是123个
     * 4. 后续的抽奖就用123作为随机数的范围值，生成的值100个都是0.1概率的奖品、20个是概率0.02的奖品、最后是3个是0.003的奖品。
     */
    private void assembleLotteryStrategy(String key, List<StrategyAwardEntity> strategyAwardEntities) {
        // 1. 获取最小概率值
        BigDecimal minAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        
        // 2. 获取概率值总和
        BigDecimal totalAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        // 3. 用 概率值总和 / 最小概率值 得到大概总共的份数
        BigDecimal rateRange = totalAwardRate.divide(minAwardRate, 0, RoundingMode.CEILING);
        
        // 4. 生成策略奖品概率查找表「这里指需要在list集合中，存放上对应的奖品占位即可，占位越多等于概率越高」
        List<Integer> strategyAwardSearchRateTables = new ArrayList<>(rateRange.intValue());
        for (StrategyAwardEntity strategyAward : strategyAwardEntities) {
            Integer awardId = strategyAward.getAwardId();
            BigDecimal awardRate = strategyAward.getAwardRate();
            // 计算出每个概率值需要存放到查找表的数量，循环填充
            for (int i = 0; i < rateRange.multiply(awardRate)
                    .setScale(0, RoundingMode.CEILING)
                    .intValue(); i++) {
                strategyAwardSearchRateTables.add(awardId);
            }
        }
        
        // 5. 对存储的奖品进行乱序操作
        Collections.shuffle(strategyAwardSearchRateTables);
        
        // 6. 生成出Map集合，key值，对应的就是后续的概率值。通过概率来获得对应的奖品ID
        Map<Integer, Integer> shuffleStrategyAwardSearchRateTable = new LinkedHashMap<>();
        for (int i = 0; i < strategyAwardSearchRateTables.size(); i++) {
            shuffleStrategyAwardSearchRateTable.put(i, strategyAwardSearchRateTables.get(i));
        }
        
        // 7. 存放到 Redis
        repository.storeStrategyAwardSearchRateTable(key, shuffleStrategyAwardSearchRateTable.size(),
                shuffleStrategyAwardSearchRateTable);
    }
    
    @Override
    public Integer getRandomAwardId(Long strategyId) {
        // 分布式部署下，不一定为当前应用做的策略装配。也就是值不一定会保存到本应用，而是分布式应用，所以需要从 Redis 中获取。
        // 实际上就是获取到奖品枚举列表的长度
        int rateRange = repository.getRateRange(strategyId);
        // 奖品枚举列表的长度范围内生成的随机值，得到随机的奖品,返回奖品id
        return repository.getStrategyAwardAssemble(String.valueOf(strategyId), new SecureRandom().nextInt(rateRange));
    }
    
    /**
     * 根据权重规则的值进行抽取随机结果
     *
     * @param strategyId
     * @param ruleWeightValue
     * @return
     */
    @Override
    public Integer getRandomAwardId(Long strategyId, String ruleWeightValue) {
        // 组装key
        String key = String.valueOf(strategyId)
                .concat("_")
                .concat(ruleWeightValue);
        
        // 分布式部署下，不一定为当前应用做的策略装配。也就是值不一定会保存到本应用，而是分布式应用，所以需要从 Redis 中获取。
        int rateRange = repository.getRateRange(key);
        // 通过生成的随机值，获取概率值奖品查找表的结果
        return repository.getStrategyAwardAssemble(key, new SecureRandom().nextInt(rateRange));
    }
    
    /**
     * 根据策略id和奖品id,扣减奖品缓存库存
     *
     * @param strategyId
     * @param awardId
     * @return
     */
    @Override
    public Boolean subtractionAwardStock(Long strategyId, Integer awardId) {
        String cacheKey = Constants.RedisKey.STRATEGY_AWARD_COUNT_KEY + Constants.UNDERLINE + awardId;
        return repository.subtractionAwardStock(cacheKey);
    }
}
