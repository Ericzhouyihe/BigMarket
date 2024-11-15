package com.zhouyihe.bigmarket.domain.strategy.model.valobj;

import com.zhouyihe.bigmarket.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;
import com.zhouyihe.bigmarket.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/25 16:42
 * @description 抽奖策略规则规则值对象；值对象，没有唯一ID，仅限于从数据库查询对象
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {
    // 策略规则
    private String ruleModels;
    
    public String[] raffleCenterRuleModelList(){
        List<String> ruleModelList = new ArrayList<String>();
        String[] ruleModelValues = ruleModels.split(Constants.SPLIT);
        for (String ruleModelValue : ruleModelValues) {
            if (DefaultLogicFactory.LogicModel.isCenter(ruleModelValue)){
                ruleModelList.add(ruleModelValue);
            }
        }
        return ruleModelList.toArray(new String[0]);
    }
}
