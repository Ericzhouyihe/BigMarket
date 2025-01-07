package com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.factory;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.zhouyihe.bigmarket.domain.strategy.repository.IStrategyRepository;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.ILogicChain;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/14 17:32
 * @description 责任链工厂类
 */
@Service
public class DefaultChainFactory {
    
    private final Map<String, ILogicChain> logicChainGroup;
    
    private final IStrategyRepository repository;
    
    public DefaultChainFactory(Map<String, ILogicChain> logicChainGroup, IStrategyRepository repository) {
        this.logicChainGroup = logicChainGroup;
        this.repository = repository;
    }
    
    /**
     * 创建责任链
     * @param strategyId 抽奖策略id
     * @return 责任链的对象
     */
    public ILogicChain openLogicChain(Long strategyId) {
        // 从strategy表中抽奖策略id(strategyId)对应的策略模型(ruleModels)
        StrategyEntity strategy = repository.queryStrategyEntityByStrategyId(strategyId);
        String[] ruleModels = strategy.ruleModels();
        
        // 如果策略模型是空的,则直接配置一个default的责任链即可
        if (null == ruleModels || 0 == ruleModels.length) return logicChainGroup.get("default");
        
        // 模型不为空,则按照模型的顺序,一个一个组成责任链
        ILogicChain logicChain = logicChainGroup.get(ruleModels[0]);
        ILogicChain current = logicChain;
        // 前面创建好了头节点, 从第二个开始将后续节点拼接进入责任链中即可
        for (int i = 1; i < ruleModels.length; i++) {
            ILogicChain nextChain = logicChainGroup.get(ruleModels[i]);
            current = current.appendNext(nextChain);
        }
        // 最后拼接上默认处理节点
        current.appendNext(logicChainGroup.get("default"));
        
        return logicChain;
    }
    
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardVO {
        /** 抽奖奖品ID - 内部流转使用 */
        private Integer awardId;
        /**  */
        private String logicModel;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_DEFAULT("rule_default", "默认抽奖"),
        RULE_BLACKLIST("rule_blacklist", "黑名单抽奖"),
        RULE_WEIGHT("rule_weight", "权重规则"),
        ;

        private final String code;
        private final String info;

    }
    
}
