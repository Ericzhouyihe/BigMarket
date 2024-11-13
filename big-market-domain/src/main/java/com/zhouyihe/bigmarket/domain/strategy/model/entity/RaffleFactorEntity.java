package com.zhouyihe.bigmarket.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName RaffleFactorEntiy
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/10
 * @description: 抽奖因子实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleFactorEntity {
    // 用户id
    private String userId;
    // 策略id
    private Long strategyId;
    // 奖品id
    private Integer awardId;
}
