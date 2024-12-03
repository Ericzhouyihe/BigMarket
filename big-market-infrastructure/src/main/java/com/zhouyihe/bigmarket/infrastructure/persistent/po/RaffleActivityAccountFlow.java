package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/3 15:12
 * @description 账户流水表
 */
@Data
public class RaffleActivityAccountFlow {
    /** 主键id */
    private String id ;
    /** 用户id */
    private String userId ;
    /** 活动id */
    private Integer activityId ;
    /** 总次数 */
    private Integer totalCount ;
    /** 日次数 */
    private Integer dayCount ;
    /** 流水id-生成的唯一id */
    private String flowId ;
    /** 流水渠道(activity-活动领取,sale- */
    private String flowChannel ;
    /** 业务id(外部透传,活动id,订单id) */
    private String bizId ;
    /** 创建时间 */
    private Date createTime ;
    /** 更新时间 */
    private Date updateTime ;
}
