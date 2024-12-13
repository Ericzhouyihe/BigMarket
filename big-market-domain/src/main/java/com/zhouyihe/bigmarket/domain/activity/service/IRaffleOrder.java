package com.zhouyihe.bigmarket.domain.activity.service;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityOrderEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityShopCartEntity;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:37
 * @description 抽奖活动订单接口
 */
public interface IRaffleOrder {
    
    /**
     * 以sku创建抽奖活动订单,获得参与抽奖的资格(可消耗的次数)
     *
     * @param activityShopCartEntity 活动sku实体,通过sku领取活动
     * @return 活动参与记录实体
     */
    ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity);
}
