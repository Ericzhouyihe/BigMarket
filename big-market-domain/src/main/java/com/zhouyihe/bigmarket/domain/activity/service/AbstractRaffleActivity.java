package com.zhouyihe.bigmarket.domain.activity.service;

import com.alibaba.fastjson.JSON;
import com.zhouyihe.bigmarket.domain.activity.model.entity.*;
import com.zhouyihe.bigmarket.domain.activity.repository.IActivityRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:49
 * @description 抽奖活动抽象类，定义标准的流程
 */
@Slf4j
public class AbstractRaffleActivity implements IRaffleOrder {
    protected IActivityRepository activityRepository;
    
    public AbstractRaffleActivity(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    
    /**
     * 以sku创建抽奖活动订单,获得参与抽奖的资格(可消耗的次数)
     *
     * @param activityShopCartEntity 活动sku实体,通过sku领取活动
     * @return 活动参与记录实体
     */
    @Override
    public ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity) {
        // 1. 通过sku查询活动信息
        ActivitySkuEntity activitySkuEntity = activityRepository.queryActivitySku(activityShopCartEntity.getSku());
        // 2. 查询活动信息
        ActivityEntity activityEntity = activityRepository.queryRaffleActivityByActivityId(
                activitySkuEntity.getActivityId());
        // 3. 查询次数信息（用户在活动上可参与的次数）
        ActivityCountEntity activityCountEntity = activityRepository.queryRaffleActivityCountByActivityCountId(
                activitySkuEntity.getActivityCountId());
        
        log.info("查询结果：{} {} {}", JSON.toJSONString(activitySkuEntity), JSON.toJSONString(activityEntity),
                JSON.toJSONString(activityCountEntity));
        
        return ActivityOrderEntity.builder().build();
    }
}
