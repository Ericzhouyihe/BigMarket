package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 周益和
* @description 针对表【raffle_activity_order(抽奖活动订单表)】的数据库操作Mapper
* @createDate 2024-12-03 15:26:56
*/
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IRaffleActivityOrderDao {
    
    @DBRouter(key = "userId")
    void insert(RaffleActivityOrder raffleActivityOrder);
    
    // 只有一个userId参数,就没用配置key
    @DBRouter
    List<RaffleActivityOrder> queryRaffleActivityOrderByUserId(String userId);

}
