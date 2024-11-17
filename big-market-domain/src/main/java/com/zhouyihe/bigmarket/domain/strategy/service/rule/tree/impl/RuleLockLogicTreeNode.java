package com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.impl;

import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.zhouyihe.bigmarket.domain.strategy.repository.IStrategyRepository;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/15 13:39
 * @description 次数锁节点
 */
@Slf4j
@Component("rule_lock")
public class RuleLockLogicTreeNode implements ILogicTreeNode {
    
    @Resource
    private IStrategyRepository repository;
    
    // 用户抽奖次数
    private Long userRaffleCount = 0L;
    
    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        
        log.info("规则过滤-权重范围 userId:{} strategyId:{} ruleModel:{}", userId, strategyId,
                DefaultLogicFactory.LogicModel.RULE_LOCK);
        
        // 查询配置值
        String ruleValue = repository.queryStrategyRuleValue(strategyId, Integer.valueOf(userId),
                DefaultLogicFactory.LogicModel.RULE_LOCK.getCode());
        
        long raffleCount = Long.parseLong(ruleValue);
        
        // 用户抽奖次数 大与等于 配置值 放行进行后续的流程
        if (userRaffleCount >= raffleCount) {
            return DefaultTreeFactory.TreeActionEntity.builder()
                    .ruleLogicCheckType(RuleLogicCheckTypeVO.ALLOW)
                    .build();
        }
        
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .build();
    }
}
