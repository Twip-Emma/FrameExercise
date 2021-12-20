package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.UserDao;
import com.example.springbootcasechat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    private final UserDao userDao;

    @Autowired
    public LoginService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Boolean loginCheck(User user){
        User _user = userDao.findUser(user.getUserCard());
        return _user != null && _user.getUserPass().equals(user.getUserPass());
    }
}
