package com.zhouyihe.bigmarket.trigger.listener;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.zhouyihe.bigmarket.domain.activity.service.ISkuStock;
import com.zhouyihe.bigmarket.types.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/23 16:07
 * @description 活动sku库存耗尽
 */
@Slf4j
@Component
public class ActivitySkuStockZeroCustomer {
    
    @Value("${spring.rabbitmq.topic.activity_sku_stock_zero}")
    private String topic;
    
    @Resource
    private ISkuStock skuStock;
    
    @RabbitListener(queuesToDeclare = @Queue(value = "activity_sku_stock_zero"))
    public void listener(String message) {
        try {
            log.info("监听活动sku库存消耗为0消息 topic: {} message: {}", topic, message);
            // 转换对象
            BaseEvent.EventMessage<Long> eventMessage = JSON.parseObject(message,
                    new TypeReference<BaseEvent.EventMessage<Long>>() {
                    }.getType());
            Long sku = eventMessage.getData();
            // 清空对应sku的库存
            skuStock.clearActivitySkuStock(sku);
            // 清空队列 「此时就不需要延迟更新数据库记录了」
            skuStock.clearQueueValue();
        } catch (Exception e) {
            log.error("监听活动sku库存消耗为0消息，消费失败 topic: {} message: {}", topic, message);
            throw e;
        }
    }
}
