package com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.engine;

import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/15 13:49
 * @description 规则树组合接口
 */
public interface IDecisionTreeEngine{
    /**
     * 根据抽奖次数判断、库存判断、兜底兜里返回最终的可获得奖品信息
     * @param userId
     * @param strategyId
     * @param awardId
     * @return
     */
    DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId);
}
