package com.zhouyihe.bigmarket.types.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/19 15:58
 * @description 返回格式
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> implements Serializable {
    
    private String code;
    private String info;
    private T data;
}
