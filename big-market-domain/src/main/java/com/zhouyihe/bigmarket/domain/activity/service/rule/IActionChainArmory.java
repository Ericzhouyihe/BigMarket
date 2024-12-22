package com.zhouyihe.bigmarket.domain.activity.service.rule;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/16 15:53
 * @description 抽奖动作责任链-装配
 */
public interface IActionChainArmory {
    
    IActionChain next();
    
    IActionChain appendNext(IActionChain next);
}
