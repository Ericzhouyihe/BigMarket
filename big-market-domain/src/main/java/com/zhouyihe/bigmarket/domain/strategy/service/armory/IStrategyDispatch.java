package com.zhouyihe.bigmarket.domain.strategy.service.armory;

/**
 * @ClassName IStrategyDispath
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/9
 * @description: 策略抽奖的调度
 */
public interface IStrategyDispatch {
    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param strategyId 策略ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);
    
    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);
}
