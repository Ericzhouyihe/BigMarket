package com.zhouyihe.bigmarket.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:41
 * @description 活动账户实体对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityAccountEntity {
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 活动ID
     */
    private Long activityId;
    
    /**
     * 总次数
     */
    private Integer totalCount;
    
    /**
     * 总次数-剩余
     */
    private Integer totalCountSurplus;
    
    /**
     * 日次数
     */
    private Integer dayCount;
    
    /**
     * 日次数-剩余
     */
    private Integer dayCountSurplus;
    
    /**
     * 月次数
     */
    private Integer monthCount;
    
    /**
     * 月次数-剩余
     */
    private Integer monthCountSurplus;
}
