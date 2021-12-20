package com.example.springbootcasechat.tool;

import com.example.springbootcasechat.dao.ChatDao;
import com.example.springbootcasechat.entity.Chat;
import com.example.springbootcasechat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/20 10:00
 */
@Component
public class GetChatLimit {
    private final ChatDao chatDao;

    @Autowired
    public GetChatLimit(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    //如果聊天记录大于20，则只取后20行的记录
    public List<Chat> getChatTail(HttpSession session){
        Integer listTotal = getListTotal(session);
        int i = listTotal - 20;
        String roomId = (String) session.getAttribute("roomid");
        List<Chat> limitChat = chatDao.findLimitChat(i, 20,roomId);
        return limitChat;
    }

    public Integer getListTotal(HttpSession session){
        String roomId = (String) session.getAttribute("roomid");
        List<Chat> allChat = chatDao.findAllChat(roomId);
        return allChat.size();
    }

    public List<Chat> getChatTarget(HttpSession session){
        int i = (Integer) session.getAttribute("ChatHead");
        String roomId = (String) session.getAttribute("roomid");
        List<Chat> limitChat = chatDao.findLimitChat(i, 20,roomId);
        return limitChat;
    }
}
