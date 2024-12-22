package com.zhouyihe.bigmarket.domain.activity.service;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivitySkuEntity;
import com.zhouyihe.bigmarket.domain.activity.repository.IActivityRepository;
import com.zhouyihe.bigmarket.domain.activity.service.rule.factory.DefaultActivityChainFactory;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/16 15:54
 * @description 抽奖活动的支撑类
 */
public class RaffleActivitySupport {
    
    protected DefaultActivityChainFactory defaultActivityChainFactory;
    
    protected IActivityRepository activityRepository;
    
    public RaffleActivitySupport(DefaultActivityChainFactory defaultActivityChainFactory,
            IActivityRepository activityRepository) {
        this.defaultActivityChainFactory = defaultActivityChainFactory;
        this.activityRepository = activityRepository;
    }
    
    public ActivitySkuEntity queryActivitySku(Long activityId) {
        return activityRepository.queryActivitySku(activityId);
    }
    
    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        return activityRepository.queryRaffleActivityByActivityId(activityId);
    }
    
    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityId) {
        return activityRepository.queryRaffleActivityCountByActivityCountId(activityId);
    }
}
