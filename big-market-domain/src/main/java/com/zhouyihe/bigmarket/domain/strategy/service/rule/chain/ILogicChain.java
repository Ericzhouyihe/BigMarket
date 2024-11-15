package com.zhouyihe.bigmarket.domain.strategy.service.rule.chain;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/14 13:11
 * @description 责任链接口
 */
public interface ILogicChain extends ILoginChainArmory {
    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    Integer logic(String userId, Long strategyId);
    
}
