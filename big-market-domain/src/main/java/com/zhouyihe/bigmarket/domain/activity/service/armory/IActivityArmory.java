package com.zhouyihe.bigmarket.domain.activity.service.armory;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/22 20:52
 * @description 活动装配预热
 */
public interface IActivityArmory {
    
    /**
     * 活动装配
     * @param sku
     * @return
     */
    boolean assembleActivitySku(Long sku);
}