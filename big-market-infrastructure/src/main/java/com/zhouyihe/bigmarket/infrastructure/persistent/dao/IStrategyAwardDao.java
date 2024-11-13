package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.Award;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName IStrategyAward
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/5
 * @description: 抽奖策略奖品明细 - 概率、规则 DAO
 */
@Mapper
public interface IStrategyAwardDao {
    
    List<StrategyAward> queryAwardList();
    
    List<StrategyAward> queryStrategyAwardListByStrategyId(Long strategyId);
    
    String queryStrategyAwardRuleModels(StrategyAward strategyAward);
}
