package com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.impl;

import com.zhouyihe.bigmarket.domain.strategy.service.armory.IStrategyDispatch;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.AbstractLogicChain;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/14 13:25
 * @description
 */
@Slf4j
@Component("default")
public class DefaultLogicChain extends AbstractLogicChain {
    
    @Resource
    protected IStrategyDispatch strategyDispatch;
    
    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    @Override
    public DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId) {
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);
        log.info("抽奖责任链-默认处理 userId:{} strategyId:{} ruleModel:{} awardId:{}", userId, strategyId, ruleModel(),
                awardId);
        return DefaultChainFactory.StrategyAwardVO.builder()
                .awardId(awardId)
                .logicModel(ruleModel())
                .build();
    }
    
    @Override
    protected String ruleModel() {
        // rule_default
        return DefaultChainFactory.LogicModel.RULE_DEFAULT.getCode();
    }
}
