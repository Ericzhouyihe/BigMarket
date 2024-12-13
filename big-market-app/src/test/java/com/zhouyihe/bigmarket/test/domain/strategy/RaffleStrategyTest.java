package com.zhouyihe.bigmarket.test.domain.strategy;

import com.alibaba.fastjson.JSON;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.RaffleAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.RaffleFactorEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.StrategyAwardStockKeyVO;
import com.zhouyihe.bigmarket.domain.strategy.service.IRaffleStock;
import com.zhouyihe.bigmarket.domain.strategy.service.IRaffleStrategy;
import com.zhouyihe.bigmarket.domain.strategy.service.armory.IStrategyArmory;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.filter.impl.RuleLockLogicFilter;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.filter.impl.RuleWeightLogicFilter;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.tree.impl.RuleLockLogicTreeNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/9/19 16:38
 * @description
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleStrategyTest {
    
    @Resource
    private IStrategyArmory strategyArmory;
    
    @Resource
    private IRaffleStrategy raffleStrategy;
    
    @Resource
    private RuleWeightLogicFilter ruleWeightLogicFilter;
    
    @Resource
    private RuleLockLogicFilter ruleLockLogicFilter;
    
    @Resource
    private RuleLockLogicTreeNode ruleLockLogicTreeNode;
    
    @Resource
    private IRaffleStock raffleStock;
    
    @Before
    public void setup() {
        // log.info("测试结果:{}", strategyArmory.assembleLotteryStrategy(100001L));
        // log.info("测试结果:{}", strategyArmory.assembleLotteryStrategy(100002L));
        // log.info("测试结果:{}", strategyArmory.assembleLotteryStrategy(100003L));
        log.info("测试结果:{}", strategyArmory.assembleLotteryStrategy(100006L));
        
        // 通过反射 mock 规则中的值
        ReflectionTestUtils.setField(ruleWeightLogicFilter, "userScore", 4900L);
        ReflectionTestUtils.setField(ruleLockLogicTreeNode, "userRaffleCount", 10L);
        // ReflectionTestUtils.setField(ruleLockLogicFilter, "userRaffleCount", 0L);
    }
    
    @Test
    public void test_performance() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                    .userId("zhouyihe")
                    .strategyId(100006L)
                    .build();
            
            RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);
            
            log.info("请求参数: {}", JSON.toJSON(raffleFactorEntity));
            log.info("测试结果: {}", JSON.toJSON(raffleAwardEntity));
        }
        // new CountDownLatch(1).await();
    }
    
    @Test
    public void test_preformRaffle_blacklist() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("user003")  // 黑名单用户 user001 user002 user003
                .strategyId(100001L)
                .build();
        
        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);
        
        log.info("请求参数: {}", JSON.toJSON(raffleFactorEntity));
        log.info("测试结果: {}", JSON.toJSON(raffleAwardEntity));
    }
    
    @Test
    public void test_raffle_center_rule_lock() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("zhouyihe")
                .strategyId(100006L)
                .build();
        
        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);
        
        log.info("请求参数: {}", JSON.toJSON(raffleFactorEntity));
        log.info("测试结果: {}", JSON.toJSON(raffleAwardEntity));
    }
    
    @Test
    public void test_takeQueueValue() throws InterruptedException {
        StrategyAwardStockKeyVO strategyAwardStockKeyVO = raffleStock.takeQueueValue();
        log.info("测试结果：{}", JSON.toJSONString(strategyAwardStockKeyVO));
    }
}
