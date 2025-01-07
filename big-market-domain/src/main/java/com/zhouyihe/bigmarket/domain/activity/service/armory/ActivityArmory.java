package com.zhouyihe.bigmarket.domain.activity.service.armory;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivitySkuEntity;
import com.zhouyihe.bigmarket.domain.activity.repository.IActivityRepository;
import com.zhouyihe.bigmarket.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/22 20:54
 * @description 活动sku预热
 */
@Slf4j
@Service
public class ActivityArmory implements IActivityArmory, IActivityDispatch {
    
    @Resource
    private IActivityRepository activityRepository;
    
    /**
     * 活动装配
     *
     * @param sku 商品sku
     * @return 是否装配成功
     */
    @Override
    public boolean assembleActivitySku(Long sku) {
        ActivitySkuEntity activitySkuEntity = activityRepository.queryActivitySku(sku);
        cacheActivitySkuStockCount(sku, activitySkuEntity.getStockCount());
        
        // 预热活动 查询时预热到缓存
        activityRepository.queryRaffleActivityByActivityId(activitySkuEntity.getActivityId());
        
        // 预热活动次数 查询时预热到缓存
        activityRepository.queryRaffleActivityCountByActivityCountId(activitySkuEntity.getActivityCountId());
        
        return true;
    }
    
    /**
     * 缓存活动sku的数量等数据
     *
     * @param sku 商品sku
     * @param stockCount 库存总量
     */
    private void cacheActivitySkuStockCount(Long sku, Integer stockCount) {
        String cacheKey = Constants.RedisKey.ACTIVITY_SKU_STOCK_COUNT_KEY + sku;
        activityRepository.cacheActivitySkuStockCount(cacheKey, stockCount);
    }
    
    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     *
     * @param sku         互动SKU
     * @param endDateTime 活动结束时间，根据结束时间设置加锁的key为结束时间
     * @return 扣减结果
     */
    @Override
    public boolean subtractionActivitySkuStock(Long sku, Date endDateTime) {
        String cacheKey = Constants.RedisKey.ACTIVITY_SKU_STOCK_COUNT_KEY + sku;
        return activityRepository.subtractionActivitySkuStock(sku, cacheKey, endDateTime);
    }
}
