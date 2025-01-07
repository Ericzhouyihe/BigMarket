package com.zhouyihe.bigmarket.domain.activity.service.rule.impl;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivitySkuEntity;
import com.zhouyihe.bigmarket.domain.activity.model.valobj.ActivityStateVO;
import com.zhouyihe.bigmarket.domain.activity.service.rule.AbstractActionChain;
import com.zhouyihe.bigmarket.types.enums.ResponseCode;
import com.zhouyihe.bigmarket.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/16 15:53
 * @description 活动规则过滤【日期、状态】
 */
@Slf4j
@Component("activity_base_action")
public class ActivityBaseActionChain extends AbstractActionChain {
    
    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity,
            ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-基础信息【有效期、状态、库存(sku)】校验开始。sku:{} activityId:{}", activitySkuEntity.getSku(),
                activityEntity.getActivityId());
        
        // 校验:活动状态
        if (!activityEntity.getState().equals(ActivityStateVO.open.getCode())) {
            throw new AppException(ResponseCode.ACTIVITY_STATE_ERROR.getCode(),
                    ResponseCode.ACTIVITY_STATE_ERROR.getInfo());
        }
        
        // 校验: 活动动日期  开始时间 <= 当前时间 <= 结束时间
        Date currentDate = new Date();
        if (activityEntity.getBeginDateTime().after(currentDate) || activityEntity.getEndDateTime()
                .before(currentDate)) {
            throw new AppException(ResponseCode.ACTIVITY_DATE_ERROR.getCode(),
                    ResponseCode.ACTIVITY_DATE_ERROR.getInfo());
        }
        
        // 校验: 活动sku库存  剩余库存从缓存中获取 --看活动库存是否为小于等于0
        if (activitySkuEntity.getStockCountSurplus() <= 0) {
            throw new AppException(ResponseCode.ACTIVITY_SKU_STOCK_ERROR.getCode(),
                    ResponseCode.ACTIVITY_SKU_STOCK_ERROR.getInfo());
        }
        
        return next().action(activitySkuEntity, activityEntity, activityCountEntity);
    }
}
