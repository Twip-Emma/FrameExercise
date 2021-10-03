package com.example.springbootcasechat.dao;

import com.example.springbootcasechat.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    @Results(id = "findUser",
            value = {
                    @Result(id = true,column = "chat_id",property = "chatId"),
                    @Result(column = "chat_time",property = "chatTime"),
                    @Result(column = "chat_user",property = "chatUser"),
                    @Result(column = "chat_text",property = "chatText"),
                    @Result(column = "admin_type",property = "adminType")
            })
    List<User> findAllUser();
}
