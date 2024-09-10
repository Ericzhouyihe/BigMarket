package com.zhouyihe.bigmarket.infrastructure.persistent.repository;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyRuleEntity;
import com.zhouyihe.bigmarket.domain.strategy.repository.IStrategyRepository;
import com.zhouyihe.bigmarket.infrastructure.persistent.dao.IStrategyAwardDao;
import com.zhouyihe.bigmarket.infrastructure.persistent.dao.IStrategyDao;
import com.zhouyihe.bigmarket.infrastructure.persistent.dao.IStrategyRuleDao;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.Strategy;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.StrategyAward;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.StrategyRule;
import com.zhouyihe.bigmarket.infrastructure.persistent.redis.IRedisService;
import com.zhouyihe.bigmarket.types.common.Constants;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StrategyRepository
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/7
 * @description: 策略仓储实现
 */
@Repository
public class StrategyRepository implements IStrategyRepository {
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyRuleDao strategyRuleDao;
    @Resource
    private IStrategyAwardDao strategyAwardDao;
    @Resource
    private IRedisService redisService;
    
    @Override
    public List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId) {
        String cacheKey = Constants.RedisKey.STRATEGY_AWARD_KEY + strategyId;
        
        List<StrategyAwardEntity> strategyAwardEntities = redisService.getValue(cacheKey);
        
        if (strategyAwardEntities != null && !strategyAwardEntities.isEmpty()) return strategyAwardEntities;
        
        // 缓存中没有,从库中读取数据
        List<StrategyAward> strategyAwards = strategyAwardDao.queryStrategyAwardListByStrategyId(strategyId);
        strategyAwardEntities = new ArrayList<>(strategyAwards.size());
        for (StrategyAward strategyAward : strategyAwards) {
            StrategyAwardEntity strategyAwardEntity = StrategyAwardEntity.builder()
                    .strategyId(strategyAward.getStrategyId())
                    .awardId(strategyAward.getAwardId())
                    .awardCount(strategyAward.getAwardCount())
                    .awardCountSurplus(strategyAward.getAwardCountSurplus())
                    .awardRate(strategyAward.getAwardRate())
                    .build();
            strategyAwardEntities.add(strategyAwardEntity);
        }
        
        // 读取完成之后存入缓存中
        redisService.setValue(cacheKey, strategyAwardEntities);
        return strategyAwardEntities;
    }
    
    @Override
    public void storeStrategyAwardSearchRateTable(String key, Integer rateRange,
                                                  Map<Integer, Integer> strategyAwardSearchRateTable) {
        // 1. 存储抽奖策略范围值,如10000,用于生成1000以内的随机数
        redisService.setValue(Constants.RedisKey.STRATEGY_RATE_RANGE_KEY + key, rateRange);
        
        // 2. 存储概率查找表
        Map<Integer, Integer> cacheRateTable = redisService.getMap(Constants.RedisKey.STRATEGY_RATE_TABLE_KEY + key);
        cacheRateTable.putAll(strategyAwardSearchRateTable);
    }
    
    @Override
    public int getRateRange(Long strategyId) {
        return getRateRange(String.valueOf(strategyId));
    }
    
    @Override
    public int getRateRange(String key) {
        return redisService.getValue(Constants.RedisKey.STRATEGY_RATE_RANGE_KEY + key);
    }
    
    @Override
    public StrategyEntity queryStrategyEntityByStrategyId(Long strategyId) {
        // 优先从缓存获取
        String cacheKey = Constants.RedisKey.STRATEGY_KEY + strategyId;
        StrategyEntity strategyEntity = redisService.getValue(cacheKey);
        if (strategyEntity != null) return strategyEntity;
        
        Strategy strategy = strategyDao.queryStrategyByStrategyId(strategyId);
        strategyEntity = StrategyEntity.builder()
                .strategyId(strategy.getStrategyId())
                .strategyDesc(strategy.getStrategyDesc())
                .ruleModels(strategy.getRuleModels())
                .build();
        return strategyEntity;
    }
    
    @Override
    public StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel) {
        StrategyRule strategyRuleReq = new StrategyRule();
        strategyRuleReq.setStrategyId(strategyId);
        strategyRuleReq.setRuleModel(ruleModel);
        StrategyRule strategyRuleRes = strategyRuleDao.queryStrategyRule(strategyRuleReq);
        return StrategyRuleEntity.builder()
                .strategyId(strategyRuleRes.getStrategyId())
                .awardId(strategyRuleRes.getAwardId())
                .ruleType(strategyRuleRes.getRuleType())
                .ruleModel(strategyRuleRes.getRuleModel())
                .ruleValue(strategyRuleRes.getRuleValue())
                .ruleDesc(strategyRuleRes.getRuleDesc())
                .build();
    }
    
    @Override
    public Integer getStrategyAwardAssemble(String key, Integer rateKey) {
        return redisService.getFromMap(Constants.RedisKey.STRATEGY_RATE_TABLE_KEY + key, rateKey);
    }
}
