package com.twip.spring5.service;

import com.twip.spring5.dao.UserDao;
import org.junit.rules.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//Transactional参数一览
//1.propagation传播行为，默认REQUIRED
//2.isolation隔离级级别，默认REPEATABLE_READ
//3.timeout超时时间，默认-1，以秒为单位
//4.readOnly是否只读，默认False，表示可以进行增删改查操作，改为True就只能进行查操作
//5.rollbackFor回滚，出现指定异常进行回滚
//6.noRollbackFor不回滚，出现指定异常不进行回滚
@Service
@Transactional(readOnly=false,timeout = -1,propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)//默认参数
public class UserService {
    @Autowired
    private UserDao userDao;

    //转帐的方法
    public void accountMoney() {
            //甲扣钱
            userDao.reduceMoney();
            //模拟异常
            int a = 10 / 0;
            //已加钱
            userDao.addMoney();
    }
}
