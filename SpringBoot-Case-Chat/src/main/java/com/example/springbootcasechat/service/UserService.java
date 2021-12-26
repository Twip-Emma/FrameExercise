package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.UserDao;
import com.example.springbootcasechat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public String findAllUser() {
        String userListByHtml = "";
        List<User> userList = userDao.findAllUser();
        for (User user : userList) {
            userListByHtml += "<tr><td>" + user.getUserId() + "</td><td>" + user.getUserName();
            userListByHtml += "</td><td>" + user.getUserCard() + "</td><td>" + user.getUserPass();
            userListByHtml += "</td><td>" + user.getUserName() + "</td><td>" + user.getUserExp() + "</td></tr>";
        }
        if (userListByHtml.equals("")) {
            return userListByHtml;
        } else {
            return "没有用户";
        }
    }

    public String findUserName(String userCard) {
        return userDao.findUser(userCard).getUserName();
    }

    public User findUser(String userCard) {
        return userDao.findUser(userCard);
    }

    public void changeUserName(String userCard, String userName) {
        userDao.changeUserName(userName, userCard);
    }

    public void userGetExp(String userCard) {
        userDao.userGetExp(userCard);
    }
}
