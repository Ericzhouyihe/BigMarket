package com.zhouyihe.bigmarket.domain.strategy.repository;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyRuleEntity;

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
    
    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);
    
    Integer getStrategyAwardAssemble(String key, Integer rateKey);
    
    int getRateRange(Long strategyId);
    
    int getRateRange(String key);
    
    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);
    
    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);
}
