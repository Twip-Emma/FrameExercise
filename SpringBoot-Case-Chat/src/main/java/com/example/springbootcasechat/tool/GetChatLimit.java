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
    public List<Chat> getChatTail(){
        Integer listTotal = getListTotal();
        int i = listTotal - 20;
        List<Chat> limitChat = chatDao.findLimitChat(i, 20);
        return limitChat;
    }

    public Integer getListTotal(){
        List<Chat> allChat = chatDao.findAllChat();
        return allChat.size();
    }

    public List<Chat> getChatTarget(HttpSession session){
        int i = (Integer) session.getAttribute("ChatHead");
        List<Chat> limitChat = chatDao.findLimitChat(i, 20);
        return limitChat;
    }
}
