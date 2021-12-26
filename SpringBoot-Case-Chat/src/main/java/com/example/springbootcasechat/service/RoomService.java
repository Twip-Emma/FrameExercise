package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.RoomDao;
import com.example.springbootcasechat.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/20 15:37
 */
@Component
public class RoomService {
    @Autowired
    RoomDao roomDao;

//    public RoomService(RoomDao roomDao) {
//        this.roomDao = roomDao;
//    }

    //展示所有房间返回房间对象列表
    public List<Room> findAllRoom(){
        return roomDao.findAllRoom();
    }

    //根据房间ID获取房间名称
    public String findRoomNameById(String id){
        Room re = roomDao.findRoomNameById(id);
        return re.getRoomName();
    }
}
