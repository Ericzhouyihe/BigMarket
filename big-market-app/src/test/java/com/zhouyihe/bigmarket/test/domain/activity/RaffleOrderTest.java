package com.zhouyihe.bigmarket.test.domain.activity;

import com.alibaba.fastjson.JSON;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityOrderEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityShopCartEntity;
import com.zhouyihe.bigmarket.domain.activity.service.IRaffleOrder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 23:24
 * @description 抽奖活动订单 测试类
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleOrderTest {
    @Resource
    private IRaffleOrder raffleOrder;
    
    @Test
    public void test_createRaffleActivityOrder() {
        ActivityShopCartEntity activityShopCartEntity = new ActivityShopCartEntity();
        activityShopCartEntity.setUserId("zhouyihe");
        activityShopCartEntity.setSku(9011L);
        ActivityOrderEntity raffleActivityOrder = raffleOrder.createRaffleActivityOrder(activityShopCartEntity);
        log.info("测试结果：{}", JSON.toJSONString(raffleActivityOrder));
    }
}
