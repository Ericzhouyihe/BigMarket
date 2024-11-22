package com.zhouyihe.bigmarket.api.dto;

import lombok.Data;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/19 16:05
 * @description 获取抽奖奖品列表,请求对象
 */
@Data
public class RaffleAwardListRequestDTO {
    
    // 抽奖策略id
    private Long strategyId;
}
