package com.zhouyihe.bigmarket.domain.strategy.service.rule;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.RuleActionEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @ClassName ILogicFilter
 * @author ZhouYihe 1552951165@qq.com
 * @date 2024/9/10
 * @description 抽奖规则过滤接口
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {
    
    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);
    
}
