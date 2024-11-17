package com.zhouyihe.bigmarket.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/15 13:34
 * @description 规则树节点对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleTreeNodeVO {
    
    /** 规则树ID */
    private String treeId;
    /** 规则Key */
    private String ruleKey;
    /** 规则描述 */
    private String ruleDesc;
    /** 规则比值 */
    private String ruleValue;
    
    /** 规则连线 */
    private List<RuleTreeNodeLineVO> treeNodeLineVOList;
}
