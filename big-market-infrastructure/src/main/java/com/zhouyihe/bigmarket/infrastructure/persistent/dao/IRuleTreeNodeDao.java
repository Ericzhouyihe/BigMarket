package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhouyihe
 * @since 2024-11-16
 */
@Mapper
public interface IRuleTreeNodeDao {
    /**
     * 规则key,规则描述,规则比值对象的集合
     * 相当于配置的几种树的节点
     * @param treeId 树id
     * @return 节点集合
     */
    List<RuleTreeNode> queryRuleTreeNodeListByTreeId(String treeId);
    
}
