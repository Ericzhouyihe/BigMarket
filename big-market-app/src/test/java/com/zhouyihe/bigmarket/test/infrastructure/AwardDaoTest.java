package com.zhouyihe.bigmarket.test.infrastructure;

import com.alibaba.fastjson.JSON;
import com.zhouyihe.bigmarket.infrastructure.persistent.dao.IAwardDao;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.Award;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AwardDaoTest
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/5
 * @description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardDaoTest {
    
    @Resource
    private IAwardDao awardDao;
    @Test
    public void test_queryAward() {
        List<Award> awards = awardDao.queryAwardList();
        log.info("测试结果：{}", JSON.toJSONString(awards));
    }
}
