package com.zhouyihe.bigmarket.test.infrastructure;

import com.alibaba.fastjson.JSON;
import com.zhouyihe.bigmarket.infrastructure.persistent.dao.IRaffleActivityOrderDao;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/4 17:03
 * @description 策略活动测试类
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityOrderDaoTest {
    
    private final EasyRandom easyRandom = new EasyRandom();
    @Resource
    private IRaffleActivityOrderDao raffleActivityOrderDao;
    
    @Test
    public void test_insert_random() {
        for (int i = 0; i < 5; i++) {
            RaffleActivityOrder raffleActivityOrder = new RaffleActivityOrder();
            // EasyRandom 可以通过指定对象类的方式，随机生成对象值。如；easyRandom.nextObject(String.class)、easyRandom.nextObject(RaffleActivityOrder.class)
            raffleActivityOrder.setUserId(easyRandom.nextObject(String.class));
            raffleActivityOrder.setActivityId(100301L);
            raffleActivityOrder.setActivityName("测试活动");
            raffleActivityOrder.setStrategyId(100006L);
            raffleActivityOrder.setOrderId(RandomStringUtils.randomNumeric(12));
            raffleActivityOrder.setOrderTime(new Date());
            raffleActivityOrder.setState("not_used");
            
            // 插入数据
            raffleActivityOrderDao.insert(raffleActivityOrder);
        }
        
        
    }
    
    @Test
    public void test_insert() {
        RaffleActivityOrder raffleActivityOrder = new RaffleActivityOrder();
        raffleActivityOrder.setUserId("xiaofuge");
        raffleActivityOrder.setActivityId(100301L);
        raffleActivityOrder.setActivityName("测试活动");
        raffleActivityOrder.setStrategyId(100006L);
        raffleActivityOrder.setOrderId(RandomStringUtils.randomNumeric(12));
        raffleActivityOrder.setOrderTime(new Date());
        raffleActivityOrder.setState("not_used");
        
        // 插入数据
        raffleActivityOrderDao.insert(raffleActivityOrder);
    }
    
    @Test
    public void test_queryRaffleActivityOrderByUserId() {
        String userId = "zhouyihe";
        List<RaffleActivityOrder> raffleActivityOrders = raffleActivityOrderDao.queryRaffleActivityOrderByUserId(
                userId);
        log.info("测试结果：{}", JSON.toJSONString(raffleActivityOrders));
    }
}