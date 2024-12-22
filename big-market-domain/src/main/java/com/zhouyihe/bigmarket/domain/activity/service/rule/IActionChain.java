package com.zhouyihe.bigmarket.domain.activity.service.rule;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/16 15:52
 * @description 下单规则过滤接口
 */
public interface IActionChain extends IActionChainArmory{
    
    /**
     * 判断是够满足设置的规则
     * @param activitySkuEntity
     * @param activityEntity
     * @param activityCountEntity
     * @return
     */
    boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity,
            ActivityCountEntity activityCountEntity);
    
}
