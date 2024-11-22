package com.zhouyihe.bigmarket.domain.strategy.model.entity;

import com.zhouyihe.bigmarket.api.dto.RaffleAwardListResponseDTO;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName Strategy
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/7
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AutoMapper(target = RaffleAwardListResponseDTO.class)
public class StrategyAwardEntity {
    
    // 抽奖策略ID
    private Long strategyId;
    // 抽奖奖品ID - 内部流转使用
    private Integer awardId;
    // 抽奖奖品标题
    private String awardTitle;
    // 抽奖奖品副标题
    private String awardSubtitle;
    // 奖品库存总量
    private Integer awardCount;
    // 奖品库存剩余
    private Integer awardCountSurplus;
    // 奖品中奖概率
    private BigDecimal awardRate;
    // 排序
    private Integer sort;
    
}
