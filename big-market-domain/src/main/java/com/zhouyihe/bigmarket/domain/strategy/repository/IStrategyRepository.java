package com.zhouyihe.bigmarket.domain.strategy.repository;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;

import java.math.BigDecimal;
import java.util.HashMap;
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
    
    void storeStrategyAwardSearchRateTable(Long strategyId, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);
    
    Integer getStrategyAwardAssemble(Long strategyId, Integer rateKey);
    
    int getRateRange(Long strategyId);
}
