package com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.factory;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyEntity;
import com.zhouyihe.bigmarket.domain.strategy.repository.IStrategyRepository;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.ILogicChain;
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
        
        ILogicChain logicChain = logicChainGroup.get(ruleModels[0]);
        ILogicChain current = logicChain;
        for (int i = 1; i < ruleModels.length; i++) {
            ILogicChain nextChain = logicChainGroup.get(ruleModels[i]);
            current = current.appendNext(nextChain);
        }
        
        current.appendNext(logicChainGroup.get("default"));
        
        return logicChain;
    }
}
