package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.Strategy;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName IStrategyRule
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/5
 * @description: 策略规则
 */
@Mapper
public interface IStrategyRuleDao {
    
    List<StrategyRule> queryStrategyRuleList();
    
    /**
     * 根据strategyId(策略id)和规则模型查询对应的策略
     * @param strategyRuleReq
     * @return
     */
    StrategyRule queryStrategyRule(StrategyRule strategyRuleReq);
    
    String queryStrategyRuleValue(StrategyRule strategyRuleReq);
}
