package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

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
    
    /**
     * 根据抽奖策略id查询
     *
     * @param strategyId
     * @return
     */
    List<StrategyAward> queryStrategyAwardListByStrategyId(Long strategyId);
    
    /**
     * 根据策略id和奖品id查询对应的rule_models
     * @param strategyAward
     * @return
     */
    String queryStrategyAwardRuleModels(StrategyAward strategyAward);
    
    /**
     * 更新数据库库存
     *
     * @param strategyAward
     */
    void updateStrategyAwardStock(StrategyAward strategyAward);
    
    /**
     * 查询所有符合的策略奖品
     *
     * @param strategyAward
     * @return
     */
    StrategyAward queryStrategyAward(StrategyAward strategyAward);
}
