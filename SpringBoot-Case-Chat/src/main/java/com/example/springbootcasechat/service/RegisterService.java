package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.UserDao;
import com.example.springbootcasechat.entity.User;
import com.example.springbootcasechat.utils.GetUUID;
import com.example.springbootcasechat.utils.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RegisterService {
    private final UserDao userDao;
    private final GetUUID getUUID;
    private final MyPasswordEncoder myPasswordEncoder;

    @Autowired
    public RegisterService(UserDao userDao,GetUUID getUUID,MyPasswordEncoder myPasswordEncoder) {
        this.userDao = userDao;
        this.getUUID = getUUID;
        this.myPasswordEncoder = myPasswordEncoder;
    }

    public Boolean creatNewUser(User user){
        if(userDao.findUser(user.getUserCard()) != null){
            return false;
        }else{
            String nowTime = new Date().toString();
            user.setUserId(nowTime + user.getUserCard());
            String uuid = getUUID.getUserUUID();
            String encodePass = myPasswordEncoder.getEncodePass(user.getUserPass());
            userDao.creatNewUser(uuid, user.getUserCard(), encodePass, user.getUserName());
            return true;
        }
    }
}
