package com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.engine;

import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/15 13:49
 * @description 规则树组合接口
 */
public interface IDecisionTreeEngine{
    DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId);
}
