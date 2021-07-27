package com.twip.bookstore.dao;

import com.twip.bookstore.entity.User;

public interface UserDao {
    //新建用户
    public void newUser(User user);

    //登录验证
    public Boolean loginCheck(String account);

    //浏览书店
    public String showBookList();

    //将书加入购物车
    public Boolean insertBook(String id);

    //结算购物车
    public Boolean settleShop();
}
