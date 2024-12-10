package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/3 15:07
 * @description 抽奖活动表
 */
@Data
public class RaffleActivity {
    /** 主键id */
    private Integer id ;
    /** 活动id */
    private Integer activityId ;
    /** 活动名称 */
    private String activityName ;
    /** 活动描述 */
    private String activityDesc ;
    /** 开始时间 */
    private Date beginDateTime ;
    /** 结束时间 */
    private Date endDateTime ;
    /** 库存总量 */
    private Integer stockCount ;
    /** 剩余库存 */
    private Integer stockCountSurplus ;
    /** 活动参与次数配置 */
    private Integer activityCountId ;
    /** 策略id */
    private Integer strategyId ;
    /** 活动状态 */
    private String state ;
    /** 创建时间 */
    private Date createTime ;
    /** 更新时间 */
    private Date updateTime ;
}
