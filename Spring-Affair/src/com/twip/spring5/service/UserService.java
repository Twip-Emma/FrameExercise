package com.twip.spring5.service;

import com.twip.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    //转帐的方法
    public void accountMoney() {
        //1.开启事务操作
        try {
            //2.开启业务逻辑
            userDao.reduceMoney();

            //模拟异常
            int a = 10 / 0;

            userDao.addMoney();
            //3.事务提交
        }catch (Exception e){
            //4.出现异常，事务回滚
        }


    }
}
