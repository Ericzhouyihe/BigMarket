package com.zhouyihe.bigmarket.domain.strategy.repository;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyRuleEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleTreeVO;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IStrategyRepository
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/7
 * @description: 策略仓储接口
 */
public interface IStrategyRepository {
    
    /**
     * 根据策略id查询奖品信息
     * @param strategyId
     * @return
     */
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);
    
    void storeStrategyAwardSearchRateTable(String key, Integer rateRange,
                                           Map<Integer, Integer> strategyAwardSearchRateTable);
    
    Integer getStrategyAwardAssemble(String key, Integer rateKey);
    
    int getRateRange(Long strategyId);
    
    int getRateRange(String key);
    
    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);
    
    /**
     * 获取抽奖规则类型为rule_weight的抽奖规则
     * @param strategyId 策略id
     * @param ruleModel "rule_weight"
     * @return
     */
    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);
    
    String queryStrategyRuleValue(Long strategyId, String ruleModel);
    
    /**
     * 查询抽奖规则的比值信息
     * @param strategyId 抽奖策略id
     * @param awardId 奖品id
     * @param ruleModel 策略模型
     * @return
     */
    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);
    
    /**
     * 根据 抽奖策略id 和 奖品id 查询对应的规则模型
     * @param strategyId 抽奖策略id
     * @param awardId 奖品id
     * @return
     */
    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);
    
    /**
     * 通过树id生产对应的规则树
     * @param treeId 树id
     * @return 规则树对象
     */
    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);
    
    /**
     * 缓存商品库存
     * @param cacheKey
     * @param awardCount
     */
    void cacheStrategyAwardCount(String cacheKey, Integer awardCount);
    
    /**
     * 扣减库存
     * @param cacheKey
     * @return
     */
    Boolean subtractionAwardStock(String cacheKey);
    
    /**
     * 通过延迟队列对数据库的库存进行扣减
     * @param strategyAwardStockKeyVO
     */
    void awardStockConsumeSendQueue(StrategyAwardStockKeyVO strategyAwardStockKeyVO);
    
    /**
     * 获取奖品库存消耗队列
     * @return
     */
    StrategyAwardStockKeyVO takeQueueValue();
    
    /**
     * 更新奖品库存消耗记录
     * @param strategyId 策略id
     * @param awardId 奖品id
     */
    void updateStrategyAwardStock(Long strategyId, Integer awardId);
    
    /**
     * 根据策略id和奖品id查找对应的策略奖品信息
     * @param strategyId 策略id
     * @param awardId 奖品id
     * @return StrategyAward
     */
    StrategyAwardEntity queryStrategyAwardEntity(Long strategyId, Integer awardId);
}
