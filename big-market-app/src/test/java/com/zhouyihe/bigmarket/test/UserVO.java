package com.zhouyihe.bigmarket.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserVO
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/5
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
    
    private String name;
    private String phone;
    private String email;
}
