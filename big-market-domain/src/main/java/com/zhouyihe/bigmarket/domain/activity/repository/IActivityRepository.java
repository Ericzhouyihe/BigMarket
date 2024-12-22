package com.zhouyihe.bigmarket.domain.activity.repository;

import com.zhouyihe.bigmarket.domain.activity.model.aggregate.CreateOrderAggregate;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:50
 * @description 活动仓储接口
 */
public interface IActivityRepository {
    
    /**
     * 根据sku获得活动sku的实体类
     *
     * @param sku
     * @return
     */
    ActivitySkuEntity queryActivitySku(Long sku);
    
    /**
     * 根据活动id获取活动的实体类
     *
     * @param activityId
     * @return
     */
    ActivityEntity queryRaffleActivityByActivityId(Long activityId);
    
    /**
     * 根据活动数量id获得活动数量的实体类
     *
     * @param activityCountId
     * @return
     */
    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);
    
    /**
     * 保存订单
     * @param createOrderAggregate
     */
    void doSaveOrder(CreateOrderAggregate createOrderAggregate);
}
