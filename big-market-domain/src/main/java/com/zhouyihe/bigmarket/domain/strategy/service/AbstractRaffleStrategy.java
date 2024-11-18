package com.zhouyihe.bigmarket.domain.strategy.service;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.RaffleAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.RaffleFactorEntity;
import com.zhouyihe.bigmarket.domain.strategy.repository.IStrategyRepository;
import com.zhouyihe.bigmarket.domain.strategy.service.armory.IStrategyDispatch;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import com.zhouyihe.bigmarket.types.enums.ResponseCode;
import com.zhouyihe.bigmarket.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName AbstractRaffleStrategy
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/10
 * @description: 抽奖策略抽象类，定义抽奖的标准流程
 */
@Slf4j
public abstract class AbstractRaffleStrategy implements IRaffleStrategy,IRaffleStock {
    
    protected final DefaultTreeFactory defaultTreeFactory;
    protected final DefaultChainFactory defaultChainFactory;
    
    // private DefaultChainFactory defaultChainFactory;
    // 策略仓储服务 -> domain层像一个大厨，仓储层提供米面粮油
    protected IStrategyRepository repository;
    // 策略调度服务 -> 只负责抽奖处理，通过新增接口的方式，隔离职责，不需要使用方关心或者调用抽奖的初始化
    protected IStrategyDispatch strategyDispatch;
    
    public AbstractRaffleStrategy(DefaultChainFactory defaultChainFactory, DefaultTreeFactory defaultTreeFactory,
                                  IStrategyDispatch strategyDispatch, IStrategyRepository repository) {
        this.defaultChainFactory = defaultChainFactory;
        this.defaultTreeFactory = defaultTreeFactory;
        this.strategyDispatch = strategyDispatch;
        this.repository = repository;
    }
    
    /**
     * 执行抽奖；用抽奖因子入参，执行抽奖计算，返回奖品信息
     *
     * @param raffleFactorEntity 抽奖因子实体对象，根据入参信息计算抽奖结果
     * @return 抽奖的奖品
     */
    @Override
    public RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity) {
        // 1. 参数校验
        String userId = raffleFactorEntity.getUserId();
        Long strategyId = raffleFactorEntity.getStrategyId();
        if (null == strategyId || StringUtils.isBlank(userId)) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }
        
        // 2. 责任链抽奖计算[这一步拿到的是初步的抽奖id,之后需要根据id处理抽奖] 注意:黑名单,权重等非默认抽奖是直接返回抽奖结果
        DefaultChainFactory.StrategyAwardVO chainStrategyAwardVO = raffleLogicChain(userId, strategyId);
        
        log.info("抽奖策略计算-责任链 userId:{} strategyId:{} awardId:{} LogicModel:{}", userId, strategyId,
                chainStrategyAwardVO.getAwardId(),
                chainStrategyAwardVO.getLogicModel());
        if (!DefaultChainFactory.LogicModel.RULE_DEFAULT.getCode().equals(chainStrategyAwardVO.getLogicModel())) {
            return RaffleAwardEntity.builder()
                    .awardId(chainStrategyAwardVO.getAwardId())
                    .build();
        }
        
        // 3. 规则树抽奖过滤【奖品ID，会根据抽奖次数判断、库存判断、兜底兜里返回最终的可获得奖品信息】
        DefaultTreeFactory.StrategyAwardVO treeStrategyAwardVO = raffleLogicTree(userId, strategyId,
                chainStrategyAwardVO.getAwardId());
        log.info("抽奖策略计算-规则树 {} {} {} {}", userId, strategyId, treeStrategyAwardVO.getAwardId(),
                treeStrategyAwardVO.getAwardRuleValue());
        
        
        // 4. 返回抽奖结果
        return RaffleAwardEntity.builder()
                .awardId(treeStrategyAwardVO.getAwardId())
                .awardConfig(treeStrategyAwardVO.getAwardRuleValue())
                .build();
        
        /* // 2. 策略查询-从抽奖策略表strategy中查出抽奖的策略
        StrategyEntity strategy = repository.queryStrategyEntityByStrategyId(strategyId);
        // 3. 抽奖前 - 规则过滤
        RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> ruleActionEntity =
                this.doCheckRaffleBeforeLogic(RaffleFactorEntity.builder()
                        .userId(userId)
                        .strategyId(strategyId)
                        .build(), strategy.ruleModels());
        // 后续流程受规则引擎影响
        if (RuleLogicCheckTypeVO.TAKE_OVER.getCode().equals(ruleActionEntity.getCode())) {
            if (DefaultLogicFactory.LogicModel.RULE_BLACKLIST.getCode().equals(ruleActionEntity.getRuleModel())) {
                // 黑名单返回固定的奖品ID
                return RaffleAwardEntity.builder()
                        .awardId(ruleActionEntity.getData().getAwardId())
                        .build();
            } else if (DefaultLogicFactory.LogicModel.RULE_WIGHT.getCode().equals(ruleActionEntity.getRuleModel())) {
                // 权重根据返回的信息进行抽奖
                RuleActionEntity.RaffleBeforeEntity raffleBeforeEntity = ruleActionEntity.getData();
                String ruleWeightValueKey = raffleBeforeEntity.getRuleWeightValueKey();
                Integer awardId = strategyDispatch.getRandomAwardId(strategyId, ruleWeightValueKey);
                return RaffleAwardEntity.builder()
                        .awardId(awardId)
                        .build();
            }
        }
        // 4. 默认抽奖流程-先得到奖品枚举列表的长度,然后随机生成一个数,表示抽奖抽中了这个数,返回奖品的id
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId); */
        
        /* // 2.责任链处理抽奖 - 前置规则的责任链处理
        ILogicChain logicChain = defaultChainFactory.openLogicChain(strategyId);
        
        // 3. 通过责任链获得 奖品id
        DefaultChainFactory.StrategyAwardVO logic = logicChain.logic(userId, strategyId);
        
        // 4. 查询奖品规则「抽奖中（拿到奖品ID时，过滤规则）、抽奖后（扣减完奖品库存后过滤，抽奖中拦截和无库存则走兜底）」
        StrategyAwardRuleModelVO strategyAwardRuleModelVO = repository.queryStrategyAwardRuleModelVO(strategyId,
                awardId); */
        
        // 5. 抽奖中 - 规则过滤
        /* RuleActionEntity<RuleActionEntity.RaffleCenterEntity> ruleActionCenterEntity = this.doCheckRaffleCenterLogic(
                RaffleFactorEntity.builder().userId(userId).strategyId(strategyId).awardId(awardId).build(),
                strategyAwardRuleModelVO.raffleCenterRuleModelList());
        
        if (RuleLogicCheckTypeVO.TAKE_OVER.getCode().equals(ruleActionCenterEntity.getCode())){
            log.info("【临时日志】中奖中规则拦截，通过抽奖后规则 rule_luck_award 走兜底奖励");
            return RaffleAwardEntity.builder()
                    .awardDesc("中奖中规则拦截，通过抽奖后规则 rule_luck_award 走兜底奖励")
                    .build();
        
        } */
        
        // 原来的返回格式
        /* return RaffleAwardEntity.builder()
                .awardId(awardId)
                .build(); */
    }
    
    /**
     * 抽奖计算,责任链抽象方法
     *
     * @param userId     用户id
     * @param strategyId 策略id
     * @return 奖品id
     */
    public abstract DefaultChainFactory.StrategyAwardVO raffleLogicChain(String userId, Long strategyId);
    
    /**
     * 抽奖结果过滤，决策树抽象方法
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return 过滤结果【奖品ID，会根据抽奖次数判断、库存判断、兜底兜里返回最终的可获得奖品信息】
     */
    public abstract DefaultTreeFactory.StrategyAwardVO raffleLogicTree(String userId, Long strategyId, Integer awardId);
    
    /* protected abstract RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> doCheckRaffleBeforeLogic(
            RaffleFactorEntity raffleFactorEntity, String... logics);
    
    protected abstract RuleActionEntity<RuleActionEntity.RaffleCenterEntity> doCheckRaffleCenterLogic(
            RaffleFactorEntity raffleFactorEntity, String... logics); */
}
