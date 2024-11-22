package com.zhouyihe.bigmarket.domain.strategy.service;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/19 17:48
 * @description 策略奖品接口
 */
public interface IRaffleAward {
    
    /**
     * 根据策略id查询抽奖奖品列表配置
     * @param strategyId 策略id
     * @return 奖品列表
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);
}
