package com.zhouyihe.bigmarket.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:44
 * @description 活动购物车实体对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityShopCartEntity {
    
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 商品SKU - activity + activity count
     */
    private Long sku;
    
}
