package com.zhouyihe.bigmarket.domain.activity.event;

import com.zhouyihe.bigmarket.types.event.BaseEvent;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/23 15:36
 * @description 清空活动sku库存的消息
 */
@Component
public class ActivitySkuStockZeroMessageEvent extends BaseEvent<Long> {
    
    @Value("${spring.rabbitmq.topic.activity_sku_stock_zero}")
    private String topic;
    
    @Override
    public EventMessage<Long> buildEventMessage(Long sku) {
        return EventMessage.<Long>builder()
                .id(RandomStringUtils.randomNumeric(11))
                .timestamp(new Date())
                .data(sku)
                .build();
    }
    
    @Override
    public String topic() {
        return topic;
    }
}
