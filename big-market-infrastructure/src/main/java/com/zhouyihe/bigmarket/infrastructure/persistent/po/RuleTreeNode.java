package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhouyihe
 * @since 2024-11-16
 */
@Data
public class RuleTreeNode {
    
    /**
     * 自增ID
     */
    private Long id;
    
    /**
     * 规则树ID
     */
    private String treeId;
    
    /**
     * 规则Key
     */
    private String ruleKey;
    
    /**
     * 规则描述
     */
    private String ruleDesc;
    
    /**
     * 规则比值
     */
    private String ruleValue;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    
}
