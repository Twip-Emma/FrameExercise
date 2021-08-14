package com.example.springbootcase1.dao;

import com.example.springbootcase1.entity.Book;
import com.example.springbootcase1.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from book_store_user")
    @Results(id = "userMap",
            value = {
                    @Result(id = true,column = "user_id",property = "userId"),
                    @Result(column = "user_account",property = "userAccount"),
                    @Result(column = "user_password",property = "userPassword"),
                    @Result(column = "user_name",property = "userName"),
                    @Result(column = "user_vip",property = "userVip"),
                    @Result(column = "user_balance",property = "userBalance"),
            })
    List<User> findAll();
}
