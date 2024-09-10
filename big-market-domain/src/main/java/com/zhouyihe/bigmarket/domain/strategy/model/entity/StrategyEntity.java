package com.zhouyihe.bigmarket.domain.strategy.model.entity;

import com.zhouyihe.bigmarket.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName StrategyEntity
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/9
 * @description: 策略实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyEntity {
    /**
     * 抽奖策略ID
     */
    private Long strategyId;
    
    /**
     * 抽奖策略描述
     */
    private String strategyDesc;
    
    /**
     * 抽奖规则模型
     */
    private String ruleModels;
    
    public String[] ruleModels() {
        if (StringUtils.isBlank(ruleModels)) return null;
        return ruleModels.split(Constants.SPLIT);
    }
    
    public String getRuleWeight() {
        String[] ruledModels = this.ruleModels();
        for (String ruledModel : ruledModels) {
            if (ruledModel.equals("rule_weight")) return ruledModel;
        }
        return null;
    }
}
