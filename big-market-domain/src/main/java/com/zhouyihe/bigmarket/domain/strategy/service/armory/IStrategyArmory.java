package com.zhouyihe.bigmarket.domain.strategy.service.armory;

/**
 * @ClassName I
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/7
 * @description:
 */
public interface IStrategyArmory {
    
    boolean  assembleLotteryStrategy(Long strategyId);
    
    Integer getRandomAwardId(Long strategyId);
}
