package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.UserDao;
import com.example.springbootcasechat.entity.User;
import com.example.springbootcasechat.tool.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    private final UserDao userDao;
    private final MyPasswordEncoder myPasswordEncoder;

    @Autowired
    public LoginService(UserDao userDao,MyPasswordEncoder myPasswordEncoder) {
        this.userDao = userDao;
        this.myPasswordEncoder = myPasswordEncoder;
    }

    public Boolean loginCheck(User user){
        User _user = userDao.findUser(user.getUserCard());
        if(_user == null){
            return false;
        }
//        return _user != null && _user.getUserPass().equals(user.getUserPass());
        return myPasswordEncoder.loginCheck(user, _user.getUserPass());
    }

    public String getEncodePassword(String rawPassword){
        return myPasswordEncoder.getEncodePass(rawPassword);
    }
}
