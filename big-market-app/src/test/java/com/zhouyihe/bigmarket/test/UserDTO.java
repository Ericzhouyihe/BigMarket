package com.zhouyihe.bigmarket.test;

import lombok.*;

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
public class UserDTO {
    private String id;
    private String name;
    private String phone;
    private String email;
}
