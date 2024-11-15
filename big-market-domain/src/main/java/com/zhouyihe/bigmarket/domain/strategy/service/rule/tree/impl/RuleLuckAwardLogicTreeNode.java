package com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.impl;

import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/15 13:39
 * @description 兜底奖励节点
 */
@Slf4j
@Component("rule_luck_award")
public class RuleLuckAwardLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .strategyAwardData(DefaultTreeFactory.StrategyAwardData.builder()
                        .awardId(101)
                        .awardRuleValue("1,100")
                        .build())
                .build();
    }
}
