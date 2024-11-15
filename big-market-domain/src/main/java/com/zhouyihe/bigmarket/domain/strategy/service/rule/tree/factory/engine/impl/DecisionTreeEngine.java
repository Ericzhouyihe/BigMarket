package com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.engine.impl;

import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleTreeNodeLineVO;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleTreeNodeVO;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleTreeVO;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.ILogicTreeNode;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/15 15:55
 * @description 决策树引擎
 */
@Slf4j
public class DecisionTreeEngine implements IDecisionTreeEngine {
    
    private final Map<String, ILogicTreeNode> logicTreeNodeGroup;
    
    private final RuleTreeVO ruleTreeVO;
    
    public DecisionTreeEngine(Map<String, ILogicTreeNode> logicTreeNodeGroup, RuleTreeVO ruleTreeVO) {
        this.logicTreeNodeGroup = logicTreeNodeGroup;
        this.ruleTreeVO = ruleTreeVO;
    }
    
    @Override
    public DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId) {
        DefaultTreeFactory.StrategyAwardData strategyAwardData = null;
        
        // 获取基础信息
        String nextNode = ruleTreeVO.getTreeRootRuleNode();
        Map<String, RuleTreeNodeVO> treeNodeMap = ruleTreeVO.getTreeNodeMap();
        
        // 获取起始节点「根节点记录了第一个要执行的规则」
        RuleTreeNodeVO ruleTreeNode = treeNodeMap.get(nextNode);
        while (null != nextNode) {
            // 获取决策节点
            ILogicTreeNode logicTreeNode = logicTreeNodeGroup.get(ruleTreeNode.getRuleKey());
            
            // 决策节点计算
            DefaultTreeFactory.TreeActionEntity logicEntity = logicTreeNode.logic(userId, strategyId, awardId);
            RuleLogicCheckTypeVO ruleLogicCheckTypeVO = logicEntity.getRuleLogicCheckType();
            strategyAwardData = logicEntity.getStrategyAwardData();
            log.info("决策树引擎【{}】treeId:{} node:{} code:{}", ruleTreeVO.getTreeName(), ruleTreeVO.getTreeId(),
                    nextNode, ruleLogicCheckTypeVO.getCode());
            
            // 获取下一个节点
            nextNode = nextNode(ruleLogicCheckTypeVO.getCode(), ruleTreeNode.getTreeNodeLineVOList());
            ruleTreeNode = treeNodeMap.get(nextNode);
        }
        
        // 返回最终结果
        return strategyAwardData;
    }
    
    private String nextNode(String matterValue, List<RuleTreeNodeLineVO> ruleTreeNodeLineVOList) {
        if (null == ruleTreeNodeLineVOList || ruleTreeNodeLineVOList.isEmpty()) return null;
        for (RuleTreeNodeLineVO nodeLine : ruleTreeNodeLineVOList) {
            if ((decisionLogic(matterValue, nodeLine))) {
                return nodeLine.getRuleNodeTo();
            }
        }
        throw new RuntimeException("决策树引擎,nextNode 计算失败,未找到可执行的节点!");
    }
    
    public boolean decisionLogic(String matterValue, RuleTreeNodeLineVO nodeLine) {
        switch (nodeLine.getRuleLimitType()) {
            case EQUAL:
                return matterValue.equals(nodeLine.getRuleLimitValue().getCode());
            // 以下暂时不需要实现
            case GT:
            case LT:
            case GE:
            case LE:
            default:
                return false;
        }
    }
}
