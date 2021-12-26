package com.example.springbootcasechat.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/20 11:23
 */
@Component
public class PasswordEncoder {
    //使用codec加密
    public String encode(CharSequence rawPassword) {
        return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes()));
    }
}
