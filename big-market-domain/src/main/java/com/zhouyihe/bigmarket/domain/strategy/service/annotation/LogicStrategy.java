package com.zhouyihe.bigmarket.domain.strategy.service.annotation;

import com.zhouyihe.bigmarket.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/15 15:37
 * @description 策略自定义枚举
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogicStrategy {
    
    DefaultLogicFactory.LogicModel logicMode();
    
}
