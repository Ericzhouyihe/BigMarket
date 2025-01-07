package com.zhouyihe.bigmarket.domain.activity.service.armory;

import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/22 21:06
 * @description 活动调度-扣减库存 提供库存扣减的接口
 */
public interface IActivityDispatch {
    
    /**
     * 根据策略ID和奖品ID，扣减奖品缓存库存
     *
     * @param sku 互动SKU
     * @param endDateTime 活动结束时间，根据结束时间设置加锁的key为结束时间
     * @return 扣减结果
     */
    boolean subtractionActivitySkuStock(Long sku, Date endDateTime);
    
}
