package com.twip.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //增加钱
    @Override
    public void addMoney() {
        String sql = "update account set money=money+? where user_name=?";
        jdbcTemplate.update(sql,100,"李四");
    }

    //减少钱
    @Override
    public void reduceMoney() {
        String sql = "update account set money=money-? where user_name=?";
        jdbcTemplate.update(sql,100,"张三");
    }
}
