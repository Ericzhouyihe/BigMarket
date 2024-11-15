package com.zhouyihe.bigmarket.domain.strategy.service.rule.chain;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/14 21:59
 * @description 装配接口
 */
public interface ILoginChainArmory {
    
    ILogicChain appendNext(ILogicChain next);
    
    ILogicChain next();
}
