package com.zhouyihe.bigmarket.domain.activity.repository;

import com.zhouyihe.bigmarket.domain.activity.model.aggregate.CreateOrderAggregate;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivitySkuEntity;
import com.zhouyihe.bigmarket.domain.activity.model.valobj.ActivitySkuStockKeyVO;

import java.util.Date;

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
    
    /**
     * 缓存sku对应的库存数量
     * @param cacheKey
     * @param stockCount
     */
    void cacheActivitySkuStockCount(String cacheKey, Integer stockCount);
    
    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     * @param cacheKey
     * @param endDateTime
     * @return
     */
    boolean subtractionActivitySkuStock(Long sku, String cacheKey, Date endDateTime);
    
    /**
     * 延迟消费更新库存记录
     * @param build
     */
    void activitySkuStockConsumeSendQueue(ActivitySkuStockKeyVO activitySkuStockKeyVO);
    
    /**
     * 获取活动sku库存消耗队列
     *
     * @return 奖品库存Key信息
     * @throws InterruptedException 异常
     */
    ActivitySkuStockKeyVO takeQueueValue();
    
    /**
     * 清空队列
     */
    void clearQueueValue();
    
    /**
     * 延迟队列 + 任务趋势更新活动sku库存
     *
     * @param sku 活动商品
     */
    void updateActivitySkuStock(Long sku);
    
    /**
     * 缓存库存以消耗完毕，清空数据库库存
     *
     * @param sku 活动商品
     */
    void clearActivitySkuStock(Long sku);
}
