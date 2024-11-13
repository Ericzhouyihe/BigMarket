package com.zhouyihe.bigmarket.domain.strategy.service.rule.factory;

import com.alibaba.fastjson2.util.AnnotationUtils;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.RuleActionEntity;
import com.zhouyihe.bigmarket.domain.strategy.service.annotation.LogicStrategy;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.ILogicFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 15:30
 * @description 规则工厂
 */
@Service
public class DefaultLogicFactory {
    
    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();
    
    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        logicFilters.forEach(logic -> {
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (strategy != null) {
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }
    
    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter() {
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }
    
    @Getter
    @AllArgsConstructor
    public enum LogicModel {
        
        RULE_WIGHT("rule_weight", "【抽奖前规则】根据抽奖权重返回可抽奖范围KEY", "before"),
        RULE_BLACKLIST("rule_blacklist", "【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回", "before"),
        RULE_LOCK("rule_lock", "【抽奖中规则】抽奖n次后,对应奖品可解锁抽奖", "center"),
        RULE_LUCK_AWARD("rule_luck_award", "【抽奖后规则】幸运奖保底", "after"),
        
        ;
        
        private final String code;
        private final String info;
        private final String type;
        
        /**
         * 判断是否是抽奖中的规则
         * @param code
         * @return
         */
        public static boolean isCenter(String code) {
            /**
             * valueOf 方法是 Java 枚举类型提供的内置方法，可以将一个字符串（通常为枚举常量的名字）转换成相应的枚举值
             */
            return "center".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }
        
        /**
         * 判断是否是抽奖后的规则
         * @param code
         * @return
         */
        public static boolean isAfter(String code) {
            /**
             * valueOf 方法是 Java 枚举类型提供的内置方法，可以将一个字符串（通常为枚举常量的名字）转换成相应的枚举值
             */
            return "after".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }
        
    }
}
