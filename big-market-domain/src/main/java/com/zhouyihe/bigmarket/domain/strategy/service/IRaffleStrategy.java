package com.zhouyihe.bigmarket.domain.strategy.service;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.RaffleAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.RaffleFactorEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.RuleActionEntity;

/**
 * @ClassName IRaffleStrategy
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/10
 * @description: 抽奖策略接口
 */
    public interface IRaffleStrategy {
    
    /**
     * 执行抽奖；用抽奖因子入参，执行抽奖计算，返回奖品信息
     *
     * @param raffleFactorEntity 抽奖因子实体对象，根据入参信息计算抽奖结果
     * @return 抽奖的奖品
     */
    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);
}
