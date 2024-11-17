package com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.impl;

import com.zhouyihe.bigmarket.domain.strategy.repository.IStrategyRepository;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.AbstractLogicChain;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import com.zhouyihe.bigmarket.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/14 13:24
 * @description 黑名单方法
 */
@Slf4j
@Component("rule_blacklist")
public class BlackListLogicChain extends AbstractLogicChain {
    
    @Resource
    private IStrategyRepository strategyRepository;
    
    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID[
     * @return 奖品ID
     */
    @Override
    public DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId) {
        log.info("抽奖责任链-黑名单开始 userId:{} strategyId:{} ruleModel:{}", userId, strategyId, ruleModel());
        // 从策略规则的表中查询到strategyId对应的ruleValue(100:user001,user002,user003),就是后面的这些黑名单用户只能得到前面这个奖品id
        String ruleValue = strategyRepository.queryStrategyRuleValue(strategyId, ruleModel());
        
        // 100:user001,user002,user003 按照:号分隔，第一个是奖品id，后面是黑名单用户id
        String[] splitRuleValue = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(splitRuleValue[0]);
        String[] userBlackIds = splitRuleValue[1].split(Constants.SPLIT);
        
        // 如果userId在黑名单中，返回黑名单中的奖品id
        for (String userBlackId : userBlackIds) {
            if (userId.equals(userBlackId)) {
                log.info("抽奖责任链-黑名单接管 userId:{} strategyId:{} ruleModel:{} awardId:{}", userId, strategyId,
                        ruleModel(), awardId);
                return DefaultChainFactory.StrategyAwardVO.builder()
                        .awardId(awardId)
                        .logicModel(ruleModel())
                        .build();
            }
        }
        
        // 不是黑名单用户,过滤其他责任链
        log.info("抽奖责任链-黑名单放行 userId:{} strategyId:{} ruleModel:{}", userId, strategyId, ruleModel());
        
        return next().logic(userId, strategyId);
    }
    
    @Override
    protected String ruleModel() {
        return DefaultChainFactory.LogicModel.RULE_BLACKLIST.getCode();
    }
}
