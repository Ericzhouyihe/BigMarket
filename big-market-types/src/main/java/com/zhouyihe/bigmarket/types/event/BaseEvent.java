package com.zhouyihe.bigmarket.types.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/23 15:15
 * @description 基础时间
 */
@Data
public abstract class BaseEvent<T> {
    
    public abstract EventMessage<T> buildEventMessage(T date);
    
    public abstract String topic();
    
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EventMessage<T> {
        private String id;
        
        private Date timestamp;
        
        private T data;
    }
}
