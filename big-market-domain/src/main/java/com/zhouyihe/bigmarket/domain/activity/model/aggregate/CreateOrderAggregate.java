package com.zhouyihe.bigmarket.domain.activity.model.aggregate;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityAccountEntity;
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
     * 活动账户实体
     */
    private ActivityAccountEntity activityAccountEntity;
    
    /**
     * 活动订单实体
     */
    private ActivityOrderEntity activityOrderEntity;
    
}
