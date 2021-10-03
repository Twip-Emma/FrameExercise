package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.UserDao;
import com.example.springbootcasechat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    UserDao userDao;

    public String findAllUser(){
        String userListByHtml = "";
        List<User> userList = userDao.findAllUser();
        for(User user : userList){
            userListByHtml += "<tr><td>" + user.getUserId() + "</td><td>" + user.getUserName();
            userListByHtml += "</td><td>" + user.getUserCard() + "</td><td>" + user.getUserPass();
            userListByHtml += "</td><td>" + user.getUserName() + "</td><td>" + user.getUserExp() + "</td></tr>";
        }
        if(userListByHtml != null || userListByHtml != ""){
            return userListByHtml;
        }else{
            return "没有用户";
        }
    }
}
