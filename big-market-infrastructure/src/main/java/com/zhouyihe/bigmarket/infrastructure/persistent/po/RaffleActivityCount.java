package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/4 16:43
 * @description 抽奖活动次数配置表 持久化对象
 */
@Data
@AutoMapper(target = ActivityCountEntity.class)
public class RaffleActivityCount {
    /**
     * 自增ID
     */
    private Long id;
    
    /**
     * 活动次数编号
     */
    private Long activityCountId;
    
    /**
     * 总次数
     */
    private Integer totalCount;
    
    /**
     * 日次数
     */
    private Integer dayCount;
    
    /**
     * 月次数
     */
    private Integer monthCount;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
}
