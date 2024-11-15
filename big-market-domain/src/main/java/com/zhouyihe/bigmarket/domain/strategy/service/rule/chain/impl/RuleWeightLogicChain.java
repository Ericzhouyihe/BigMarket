package com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.impl;

import com.zhouyihe.bigmarket.domain.strategy.repository.IStrategyRepository;
import com.zhouyihe.bigmarket.domain.strategy.service.armory.IStrategyDispatch;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.AbstractLogicChain;
import com.zhouyihe.bigmarket.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/14 13:24
 * @description 权重
 */
@Slf4j
@Component("rule_weight")
public class RuleWeightLogicChain extends AbstractLogicChain {
    
    @Resource
    private IStrategyRepository repository;
    
    @Resource
    private IStrategyDispatch strategyDispatch;
    
    private Long userScore = 4500L;
    
    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    @Override
    public Integer logic(String userId, Long strategyId) {
        log.info("抽奖责任链-权重开始 userId:{} strategyId:{} ruleModel:{}", userId, strategyId, ruleModel());
        
        // 获取rule_weight的rule_value
        String ruleValue = repository.queryStrategyRuleValue(strategyId, ruleModel());
        
        // 1. 根据用户ID查询用户抽奖消耗的积分值,本章节我们先写死为固定值 后续从数据库中查询
        Map<Long, String> analyticalValueGroup = getAnaIvticaIValue(ruleValue);
        if (analyticalValueGroup == null || analyticalValueGroup.isEmpty()) return null;
        
        // 2. 转换key值,并默认排序
        List<Long> analyticalSortedKeys = new ArrayList<>(analyticalValueGroup.keySet());
        Collections.sort(analyticalSortedKeys);
        
        // 3. 找出最小符合的值，也就是【4500 积分，能找到 4000:102,103,104,105】、【5000 积分，能找到 5000:102,103,104,105,106,107】
        // 也可以通过for循环
        // Long nextValue = null;
        // for (Long analyticalSortedKey : analyticalSortedKeys) {
        //     if (userScore >= analyticalSortedKey){
        //         nextValue = analyticalSortedKey;
        //     }
        // }
        // 另外的lambda表达式
        // Long nextValue = analyticalSortedKeys.stream()
        //         .filter(key -> userScore >= key)
        //         .max(Comparator.naturalOrder())
        //         .orElse(null);
        Long nextValue = analyticalSortedKeys.stream()
                .sorted(Comparator.reverseOrder())
                .filter(key -> userScore >= key)
                .findFirst()
                .orElse(null);
        
        // 4. 根据权重规则的值进行抽取随机结果
        if (null != nextValue) {
            Integer awardId = strategyDispatch.getRandomAwardId(strategyId, analyticalValueGroup.get(nextValue));
            log.info("抽奖责任链-权重接管 userId:{} strategyId:{} ruleModel:{}", userId, strategyId, ruleModel());
            return awardId;
        }
        
        // 5.过滤其他责任链
        log.info("抽奖责任链-权重放行 userId:{} strategyId:{} ruleModel:{}", userId, strategyId, ruleModel());
        return next().logic(userId, strategyId);
        
    }
    
    /**
     * 4000:102,103,104,105 5000:102,103,104,105,106,107 6000:102,103,104,105,106,107,108,109
     * 变成这种形式
     * 4000 102,103,104,105
     * 5000 102,103,104,105,106,107
     * 6000 102,103,104,105,106,107,108,109
     *
     * @param ruleValue
     * @return
     */
    private Map<Long, String> getAnaIvticaIValue(String ruleValue) {
        String[] ruleValueGroups = ruleValue.split(Constants.SPACE);
        Map<Long, String> ruleValueMap = new HashMap<>();
        for (String ruleValueKey : ruleValueGroups) {
            // 检查输入是否为空
            if (ruleValueKey == null || ruleValueKey.isEmpty()) {
                return ruleValueMap;
            }
            // 分割字符串以获取键和值
            String[] parts = ruleValueKey.split(Constants.COLON);
            if (parts.length != 2) {
                throw new IllegalArgumentException("rule_weight rule_rule invalid input format" + ruleValueKey);
            }
            ruleValueMap.put(Long.parseLong(parts[0]), ruleValueKey);
        }
        return ruleValueMap;
    }
    
    @Override
    protected String ruleModel() {
        return "rule_weight";
    }
}
