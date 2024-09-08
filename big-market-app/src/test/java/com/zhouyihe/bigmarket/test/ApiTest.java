package com.zhouyihe.bigmarket.test;

import com.zhouyihe.bigmarket.infrastructure.persistent.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {
    
    private IRedisService redisService;

    @Test
    public void test() {
        log.info("测试完成");
    }

    public void test(UserVO userVO){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userVO.getName());
        userDTO.setPhone(userVO.getPhone());
        userDTO.setEmail(userVO.getEmail());
    }
}
