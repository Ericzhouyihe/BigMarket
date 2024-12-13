package com.zhouyihe.bigmarket.infrastructure.persistent.repository;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivitySkuEntity;
import com.zhouyihe.bigmarket.domain.activity.repository.IActivityRepository;
import com.zhouyihe.bigmarket.infrastructure.persistent.dao.IRaffleActivityCountDao;
import com.zhouyihe.bigmarket.infrastructure.persistent.dao.IRaffleActivityDao;
import com.zhouyihe.bigmarket.infrastructure.persistent.dao.IRaffleActivitySkuDao;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivity;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityCount;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivitySku;
import com.zhouyihe.bigmarket.infrastructure.persistent.redis.IRedisService;
import com.zhouyihe.bigmarket.types.common.Constants;
import io.github.linpeilie.Converter;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 22:25
 * @description 活动仓储服务实现类
 */
@Repository
public class ActivityRepository implements IActivityRepository {
    
    @Resource
    private IRedisService redisService;
    @Resource
    private IRaffleActivityDao raffleActivityDao;
    @Resource
    private IRaffleActivitySkuDao raffleActivitySkuDao;
    @Resource
    private IRaffleActivityCountDao raffleActivityCountDao;
    @Resource
    private Converter converter;
    
    /**
     * 根据sku获得活动sku的实体类
     *
     * @param sku
     * @return
     */
    @Override
    public ActivitySkuEntity queryActivitySku(Long sku) {
        RaffleActivitySku raffleActivitySku = raffleActivitySkuDao.queryActivitySku(sku);
        return ActivitySkuEntity.builder()
                .sku(raffleActivitySku.getSku())
                .activityId(raffleActivitySku.getActivityId())
                .activityCountId(raffleActivitySku.getActivityCountId())
                .stockCount(raffleActivitySku.getStockCount())
                .stockCountSurplus(raffleActivitySku.getStockCountSurplus())
                .build();
    }
    
    /**
     * 根据活动id获取活动的实体类
     *
     * @param activityId
     * @return
     */
    @Override
    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        // 优先从缓存中获取
        String cacheKey = Constants.RedisKey.ACTIVITY_KEY + activityId;
        ActivityEntity activityEntity = redisService.getValue(cacheKey);
        if (null != activityEntity) return activityEntity;
        
        // 从库中查询数据
        RaffleActivity raffleActivity = raffleActivityDao.queryRaffleActivityByActivityId(activityId);
        // 类型转化
        activityEntity = converter.convert(raffleActivity, ActivityEntity.class);
        
        // 缓存到redis
        redisService.setValue(cacheKey, activityEntity);
        return activityEntity;
    }
    
    /**
     * 根据活动数量id获得活动数量的实体类
     *
     * @param activityCountId
     * @return
     */
    @Override
    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        // 优先从缓存中获取
        String cacheKey = Constants.RedisKey.ACTIVITY_COUNT_KEY + activityCountId;
        ActivityCountEntity activityCountEntity = redisService.getValue(cacheKey);
        if (null != activityCountEntity) return activityCountEntity;
        
        // 从库中查询数据
        RaffleActivityCount raffleActivityCount = raffleActivityCountDao.queryRaffleActivityCountByActivityCountId(activityCountId);
        // 类型转化
        activityCountEntity = converter.convert(raffleActivityCount, ActivityCountEntity.class);
        
        // 缓存到redis
        redisService.setValue(cacheKey, activityCountEntity);
        return activityCountEntity;
    }
}
