package com.zhouyihe.bigmarket.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:37
 * @description 活动状态值对象
 */
@Getter
@AllArgsConstructor
public enum ActivityStateVO {
    create("create", "创建"),
    open("open", "开启"),
    close("close", "关闭"),
    ;
    
    private final String code;
    private final String desc;
}
