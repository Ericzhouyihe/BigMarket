package com.zhouyihe.bigmarket.test.infrastructure;

import com.alibaba.fastjson.JSON;
import com.zhouyihe.bigmarket.infrastructure.persistent.dao.IRaffleActivityDao;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/4 17:03
 * @description 策略活动测试类
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityDaoTest {
    
    @Resource
    private IRaffleActivityDao raffleActivityDao;
    
    @Test
    public void test_queryRaffleActivityByActivityId() {
        RaffleActivity raffleActivity = raffleActivityDao.queryRaffleActivityByActivityId(100301L);
        log.info("测试结果：{}", JSON.toJSONString(raffleActivity));
    }
}
