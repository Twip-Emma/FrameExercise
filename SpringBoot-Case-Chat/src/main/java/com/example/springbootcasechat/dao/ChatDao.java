package com.example.springbootcasechat.dao;

import com.example.springbootcasechat.entity.Chat;
import org.apache.ibatis.annotations.*;

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

    @ResultMap(value = "findChat")
    @Insert("insert into chat values(#{chatId},#{chatTime},#{chatUser},#{chatText},#{adminType})")
    void newChat(String chatId,String chatTime,String chatUser,String chatText,String adminType);
}
