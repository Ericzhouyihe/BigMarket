package com.zhouyihe.bigmarket.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/19 16:11
 * @description 抽奖请求参数
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleResponseDTO {
    
    // 奖品id
    private Integer awardId;
    // 排序编号[策略奖品配置的奖品顺序编号]
    private Integer awardIndex;
    
}
