package com.example.springbootcasechat.dao;

import com.example.springbootcasechat.entity.Chat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatDao {
    @Select("select * from chat")
    @Results(id = "findChat",
            value = {
                    @Result(id = true,column = "chat_id",property = "chatId"),
                    @Result(column = "chat_time",property = "chatTime"),
                    @Result(column = "chat_user",property = "chatUser"),
                    @Result(column = "chat_text",property = "chatText"),
                    @Result(column = "admin_type",property = "adminType")
            })
    List<Chat> findAllChat();
}
