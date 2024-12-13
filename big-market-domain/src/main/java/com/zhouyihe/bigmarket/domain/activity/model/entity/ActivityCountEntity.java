package com.zhouyihe.bigmarket.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:42
 * @description 活动次数实体对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityCountEntity {
    
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
    
}
