package com.zhouyihe.bigmarket.test.domain;

import com.zhouyihe.bigmarket.domain.strategy.service.armory.IStrategyArmory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName StrategyArmoryTest
 * @author: ZhouYihe 1552951165@qq.com
 * @date: 2024/9/7
 * @description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {
    
    @Resource
    private IStrategyArmory strategyArmory;
    
    @Test
    public void test_strategyArmory() {
        boolean success = strategyArmory.assembleLotteryStrategy(100002L);
        log.info("测试结果：{}", success);
    }
    
    @Test
    public void test_getAssembleRandomVal() {
        for (int i = 0; i < 10; i++) {
            log.info("测试结果:{} -- 奖品ID值", strategyArmory.getRandomAwardId(100002L));
        }
    }
    
    
}