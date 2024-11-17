package com.zhouyihe.bigmarket.domain.strategy.repository;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyRuleEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleTreeVO;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.StrategyAwardRuleModelVO;

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
    
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);
    
    void storeStrategyAwardSearchRateTable(String key, Integer rateRange,
                                           Map<Integer, Integer> strategyAwardSearchRateTable);
    
    Integer getStrategyAwardAssemble(String key, Integer rateKey);
    
    int getRateRange(Long strategyId);
    
    int getRateRange(String key);
    
    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);
    
    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);
    
    String queryStrategyRuleValue(Long strategyId, String ruleModel);
    
    /**
     * 查询抽奖规则的比值信息
     * @param strategyId
     * @param awardId
     * @param ruleModel
     * @return
     */
    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);
    
    /**
     * 根据 抽奖策略id 和 奖品id 查询对应的规则模型
     * @param strategyId
     * @param awardId
     * @return
     */
    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);
    
    /**
     * 通过树id生产对应的规则树
     * @param treeId 树id
     * @return 规则树对象
     */
    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);
}
