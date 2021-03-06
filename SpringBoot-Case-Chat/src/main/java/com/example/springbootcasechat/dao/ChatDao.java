package com.example.springbootcasechat.dao;

import com.example.springbootcasechat.entity.Chat;
import com.example.springbootcasechat.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatDao {
    @Select("select * from chat where room_id=#{roomId} order by chat_time asc")
    @Results(id = "findChat",
            value = {
                    @Result(column = "chat_id",property = "chatId"),
                    @Result(column = "chat_time",property = "chatTime"),
                    @Result(column = "chat_user",property = "chatUser"),
                    @Result(column = "chat_text",property = "chatText"),
                    @Result(column = "admin_type",property = "adminType"),
                    @Result(column = "room_id",property = "roomId")
            })
    List<Chat> findAllChat(String roomId);

    @ResultMap(value = "findChat")
    @Insert("insert into chat values(#{chatId},#{chatTime},#{chatUser},#{chatText},#{adminType},#{roomId})")
    void newChat(String chatId,String chatTime,String chatUser,String chatText,String adminType,String roomId);

    @ResultMap(value = "findChat")
    @Select("select count(*) from chat where room_id=#{roomId}")
    Integer getChatTotal(String roomId);

    @ResultMap(value = "findChat")
    @Select("select * from chat where room_id=#{roomId} order by chat_time asc limit #{a},#{b};")
    List<Chat> findLimitChat(Integer a,Integer b,String roomId);
}
