package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/3 15:14
 * @description 抽奖活动订单表 持久化对象
 */
@Data
public class RaffleActivityOrder {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 商品sku
     */
    private Long sku;
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 策略id
     */
    private Long strategyId;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 总次数
     */
    private Integer totalCount;
    /**
     * 日次数
     */
    private Integer dayCount;
    /**
     * 月次数
     */
    private Integer mouthCount;
    /**
     * 订单状态（not_used、used、expire）
     */
    private String state;
    /**
     * 业务仿重ID - 外部透传的，确保幂等
     */
    private String outBusinessNo;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
