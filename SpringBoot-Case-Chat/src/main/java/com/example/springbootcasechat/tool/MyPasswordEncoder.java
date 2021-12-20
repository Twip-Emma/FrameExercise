package com.example.springbootcasechat.tool;

import com.example.springbootcasechat.dao.UserDao;
import com.example.springbootcasechat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/20 11:25
 */
@Component
public class MyPasswordEncoder {
    private final PasswordEncoder passwordEncoder;
    private final UserDao userDao;

    @Autowired
    public MyPasswordEncoder(PasswordEncoder passwordEncoder,UserDao userDao) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    public String getEncodePass(String password){
        return passwordEncoder.encode(password);
    }

    public Boolean loginCheck(User user,String rawPassword){
        return passwordEncoder.matches(user.getUserPass(),rawPassword);
    }
}
