package com.zhouyihe.bigmarket.domain.strategy.service.rule.chain;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/14 13:17
 * @description
 */
public abstract class AbstractLogicChain implements ILogicChain{
    
    private ILogicChain next;
    
    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }
    
    @Override
    public ILogicChain next() {
        return next;
    }
    
    protected abstract String ruleModel();
    
}
