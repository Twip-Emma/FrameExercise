package com.example.springbootcasechat.dao;

import com.example.springbootcasechat.entity.Chat;
import com.example.springbootcasechat.entity.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/20 15:34
 */
@Mapper
public interface RoomDao {
    @Select("select * from room")
    @Results(id = "findRoom",
            value = {
                    @Result(column = "room_id",property = "roomId"),
                    @Result(column = "room_name",property = "roomName"),
                    @Result(column = "room_master",property = "userId")
            })
    List<Room> findAllRoom();

    //根据房间ID查名称
    @ResultMap(value = "findRoom")
    @Select("select * from room where room_id=#{id};")
    Room findRoomNameById(String id);
}
