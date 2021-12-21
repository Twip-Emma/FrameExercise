package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.RoomDao;
import com.example.springbootcasechat.dao.UserDao;
import com.example.springbootcasechat.entity.Room;
import com.example.springbootcasechat.entity.User;
import com.example.springbootcasechat.tool.GetUUID;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/20 16:48
 */
@Service
public class CreatRoomService {
    private final RoomDao roomDao;
    private final UserDao userDao;
    private final GetUUID getUUID;

    public CreatRoomService(RoomDao roomDao,UserDao userDao,GetUUID getUUID) {
        this.roomDao = roomDao;
        this.userDao = userDao;
        this.getUUID = getUUID;
    }

    //创建新房间
    public void creatNewRoom(String roomName, String userCard){
        User user = userDao.findUser(userCard);
        String roomUUID = getUUID.getRoomUUID();
        roomDao.creatNewRoom(roomUUID,roomName,user.getUserId());
    }
}
