package com.zhouyihe.bigmarket.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/15 13:29
 * @description 规则限定枚举值
 */
@Getter
@AllArgsConstructor
public enum RuleLimitTypeVO {
    EQUAL(1, "等于"),
    GT(2, "大于"),
    LT(3, "小于"),
    GE(4, "大于等于"),
    LE(5, "小于等于"),
    ENUM(6, "枚举");
    
    private final Integer code;
    private final String info;
}
