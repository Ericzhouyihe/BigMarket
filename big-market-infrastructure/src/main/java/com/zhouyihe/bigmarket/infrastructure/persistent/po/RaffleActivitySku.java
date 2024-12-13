package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.google.common.math.LongMath;
import lombok.Data;

import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 20:56
 * @description 抽奖活动sku持久化对象
 */
@Data
public class RaffleActivitySku {
    /**
     * 主键id
     */
    private Long id;
    /**
     * sku编号
     */
    private Long sku;
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 活动个人参与次数ID
     */
    private Long activityCountId;
    /**
     * 商品库存
     */
    private Integer stockCount;
    /**
     * 剩余库存
     */
    private Integer stockCountSurplus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
