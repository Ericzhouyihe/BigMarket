package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhouyihe
 * @since 2024-11-16
 */
@Mapper
public interface IRuleTreeDao {
    /**
     * 通过treeId 在 rule_tree 中查找 id,规则树名称,规则树描述,规则树的树根入口节点
     * @param treeId
     * @return
     */
    RuleTree queryRuleTreeByTreeId(String treeId);
}
