package com.zhouyihe.bigmarket.test.infrastructure;

import com.alibaba.fastjson.JSON;
import com.zhouyihe.bigmarket.domain.strategy.model.valobj.RuleTreeVO;
import com.zhouyihe.bigmarket.domain.strategy.repository.IStrategyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/16 12:51
 * @description 仓储数据查询
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyRepositoryTest {
    
    @Resource
    private IStrategyRepository strategyRepository;
    
    @Test
    public void queryRuleTreeVOByTreeId() {
        RuleTreeVO ruleTreeVO = strategyRepository.queryRuleTreeVOByTreeId("tree_lock");
        log.info("测试结果:{}", JSON.toJSONString(ruleTreeVO));
    }
}
