package com.zhouyihe.bigmarket.domain.strategy.service.armory;

/**
 * @ClassName IStrategyDispath
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/9
 * @description: 策略抽奖的调度
 */
public interface IStrategyDispatch {
    /**
     * 获取抽奖策略装配的随机结果(获取指定抽奖策略id下的随机一个奖品id)
     *
     * @param strategyId 策略ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);
    
    /**
     * 根据权重规则的值进行抽取随机结果
     * @param strategyId
     * @param ruleWeightValue
     * @return
     */
    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);
}
