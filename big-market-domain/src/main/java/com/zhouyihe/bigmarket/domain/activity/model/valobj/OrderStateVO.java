package com.zhouyihe.bigmarket.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:38
 * @description 订单状态枚举值对象（用于描述对象属性的值，如枚举，不影响数据库操作的对象，无生命周期）
 */
@Getter
@AllArgsConstructor
public enum OrderStateVO {
    completed("completed", "完成");
    
    private final String code;
    private final String desc;
}
