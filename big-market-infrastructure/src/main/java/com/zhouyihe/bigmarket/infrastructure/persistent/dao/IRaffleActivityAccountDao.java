package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityAccount;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 周益和
* @description 抽奖活动账户表
* @createDate 2024-12-03 15:26:56
*/
@Mapper
public interface IRaffleActivityAccountDao {
    
    
    void insert(RaffleActivityAccount raffleActivityAccount);
    
    int updateAccountQuota(RaffleActivityAccount raffleActivityAccount);
}
