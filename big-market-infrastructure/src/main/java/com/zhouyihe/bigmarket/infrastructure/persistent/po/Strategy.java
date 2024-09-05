package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Strategy
 * @author: zhouyihe
 * @qq: 1552951165
 * @date: 2024/9/5
 * @description:
 */
@Data
public class Strategy {
    /**
     * 自增ID
     */
    private Long id;
    
    /**
     * 抽奖策略ID
     */
    private Long strategyId;
    
    /**
     * 抽奖策略描述
     */
    private String strategyDesc;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
}
