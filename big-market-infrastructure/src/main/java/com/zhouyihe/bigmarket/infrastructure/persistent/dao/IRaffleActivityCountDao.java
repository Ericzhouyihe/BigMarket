package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 周益和
* @description
* @createDate 2024-12-03 15:27:10
*/
@Mapper
public interface IRaffleActivityCountDao {
    
    RaffleActivityCount queryRaffleActivityCountByActivityCountId(Long activityCountId);
}
