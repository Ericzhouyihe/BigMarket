package com.zhouyihe.bigmarket.domain.strategy.service.rule.tree;

import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/15 13:37
 * @description 规则树接口
 */
public interface ILogicTreeNode {
    /**
     *
     * @param userId
     * @param strategyId
     * @param awardId
     * @param ruleValue
     * @return
     */
    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue);
}
