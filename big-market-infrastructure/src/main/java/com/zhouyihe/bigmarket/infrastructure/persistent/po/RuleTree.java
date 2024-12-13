package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhouyihe
 * @since 2024-11-16
 */
@Data
public class RuleTree {
    
    /**
     * 自增ID
     */
    private Long id;
    
    /**
     * 规则树ID
     */
    private String treeId;
    
    /**
     * 规则树名称
     */
    private String treeName;
    
    /**
     * 规则树描述
     */
    private String treeDesc;
    
    /**
     * 规则树根入口规则
     */
    private String treeNodeRuleKey;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    
}
