package com.example.springbootcase1.service;

import com.example.springbootcase1.entity.User;
import com.example.springbootcase1.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserModel userModel;

    public String findAll(){
        List<User> userList = userModel.findAll();
        String msg = "<table border=\"1\"><tr><th>用户ID</th><th>昵称</th><th>VIP等级</th><th>账户余额</th></tr>";
        for(User o : userList){
            msg += "<tr><td>" + o.getUserAccount() + "</td><td>"+ o.getUserName() + "</td><td>"+ o.getUserVip();
            msg += "</td><td>" + o.getUserBalance() + "</td></tr>";
        }
        msg += "</table>";
        return msg;
    }
}
