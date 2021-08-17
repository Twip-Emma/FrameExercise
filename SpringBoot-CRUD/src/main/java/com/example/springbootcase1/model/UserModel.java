package com.example.springbootcase1.model;

import com.example.springbootcase1.dao.UserDao;
import com.example.springbootcase1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserModel {
    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findUserPass(String userAccount){
        return userDao.findUserPass(userAccount);
    }
}
