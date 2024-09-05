package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName IStrategy
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/5
 * @description: 抽奖规则
 */
@Mapper
public interface IStrategyDao {
    
    List<Strategy> queryStrategyList();
}
