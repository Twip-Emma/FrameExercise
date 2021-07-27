package com.twip.bookstore.service;

import com.twip.bookstore.dao.UserDao;
import com.twip.bookstore.entity.User;
import org.junit.rules.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(timeout = 2)
public class UserService {
    @Autowired
    private UserDao userDao;

    //服务层-新建用户
    public void newUser(User user){
        userDao.newUser(user);
    }

    //服务层-登录验证
    public void loginCheck(String account){
        Boolean re = userDao.loginCheck(account);
        if(re){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！\n请检查账号和密码或者新建用户");
        }
    }

    //服务层-显示书本列表
    public void showBookList(){
        userDao.showBookList();
    }
}
