package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.UserDao;
import com.example.springbootcasechat.entity.User;
import com.example.springbootcasechat.tool.GetUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RegisterService {
    private final UserDao userDao;
    private final GetUUID getUUID;

    @Autowired
    public RegisterService(UserDao userDao,GetUUID getUUID) {
        this.userDao = userDao;
        this.getUUID = getUUID;
    }

    public Boolean creatNewUser(User user){
        if(userDao.findUser(user.getUserCard()) != null){
            return false;
        }else{
            String nowTime = new Date().toString();
            user.setUserId(nowTime + user.getUserCard());
            String uuid = getUUID.getUserUUID();
            userDao.creatNewUser(uuid, user.getUserCard(), user.getUserPass(), user.getUserName());
            return true;
        }
    }
}
