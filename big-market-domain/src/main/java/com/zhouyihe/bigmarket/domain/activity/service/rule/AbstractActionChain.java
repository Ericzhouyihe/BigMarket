package com.zhouyihe.bigmarket.domain.activity.service.rule;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/16 15:52
 * @description 下单规则责任链抽象类
 */
public abstract class AbstractActionChain implements IActionChain{
    
    private IActionChain next;
    
    @Override
    public IActionChain next() {
        return next;
    }
    
    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return next;
    }
}
