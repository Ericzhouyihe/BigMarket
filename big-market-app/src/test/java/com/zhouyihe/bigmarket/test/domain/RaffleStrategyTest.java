package com.zhouyihe.bigmarket.test.domain;

import com.alibaba.fastjson.JSON;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.RaffleAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.RaffleFactorEntity;
import com.zhouyihe.bigmarket.domain.strategy.service.IRaffleStrategy;
import com.zhouyihe.bigmarket.domain.strategy.service.rule.impl.RuleWeightLogicFilter;
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
    private IRaffleStrategy raffleStrategy;
    
    @Resource
    private RuleWeightLogicFilter ruleWeightLogicFilter;
    
    @Before
    public void setup() {
        ReflectionTestUtils.setField(ruleWeightLogicFilter, "userScore", 4500L);
    }
    
    @Test
    public void test_preformRaffle() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("zhouyihe")
                .strategyId(100001L)
                .build();
        
        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);
        
        log.info("请求参数: {}", JSON.toJSON(raffleFactorEntity));
        log.info("测试结果: {}", JSON.toJSON(raffleAwardEntity));
    }
}
