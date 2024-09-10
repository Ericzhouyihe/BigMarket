package com.zhouyihe.bigmarket.domain.strategy.service.armory;

/**
 * @ClassName I
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/7
 * @description:
 */
public interface IStrategyArmory {
    
    /**
     * 装配抽奖策略配置「触发的时机可以为活动审核通过后进行调用」
     *
     * @param strategyId 策略ID
     * @return 装配结果
     */
    boolean assembleLotteryStrategy(Long strategyId);
    
    
}
