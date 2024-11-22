package com.zhouyihe.bigmarket.config;

import io.github.linpeilie.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/20 15:50
 * @description
 */
@Configuration
public class MapstructPlusConfig {
    @Bean
    public Converter converter() {
        return new Converter();
    }
}
