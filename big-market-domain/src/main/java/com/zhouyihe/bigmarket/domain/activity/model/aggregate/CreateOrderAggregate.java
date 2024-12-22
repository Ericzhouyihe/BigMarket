package com.zhouyihe.bigmarket.domain.activity.model.aggregate;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityOrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:46
 * @description 下单聚合对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderAggregate {
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 活动ID
     */
    private Long activityId;
    
    /**
     * 增加:总次数
     */
    private Integer totalCount;
    
    /**
     * 增加:日次数
     */
    private Integer dayCount;
    
    /**
     * 增加:月次数
     */
    private Integer mouthCount;
    
    /**
     * 活动订单实体
     */
    private ActivityOrderEntity activityOrderEntity;
    
}
