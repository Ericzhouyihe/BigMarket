package com.zhouyihe.bigmarket.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/23 14:53
 * @description 活动sku库存 key 值对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySkuStockKeyVO {
    
    /** 商品sku */
    private Long sku;
    /** 活动ID */
    private Long activityId;
}
