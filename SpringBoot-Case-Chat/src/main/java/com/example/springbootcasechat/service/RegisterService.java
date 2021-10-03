package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.UserDao;
import com.example.springbootcasechat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RegisterService {
    @Autowired
    UserDao userDao;

    public Boolean creatNewUser(User user){
        if(userDao.findUser(user.getUserCard()) != null){
            return false;
        }else{
            String nowTime = new Date().toString();
            user.setUserId(nowTime + user.getUserCard());
            userDao.creatNewUser(user.getUserId(), user.getUserCard(), user.getUserPass(), user.getUserName());
            return true;
        }
    }
}
