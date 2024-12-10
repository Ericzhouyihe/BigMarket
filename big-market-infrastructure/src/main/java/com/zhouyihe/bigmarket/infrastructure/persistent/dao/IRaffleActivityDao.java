package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivity;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 周益和
* @description 针对表【raffle_activity(抽奖活动表)】的数据库操作Mapper
* @createDate 2024-12-03 15:27:10
*/
@Mapper
public interface IRaffleActivityDao {
    
    
    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

}
