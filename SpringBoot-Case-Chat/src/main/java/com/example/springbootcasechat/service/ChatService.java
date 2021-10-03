package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.ChatDao;
import com.example.springbootcasechat.entity.Chat;
import com.example.springbootcasechat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatService {
    @Autowired
    ChatDao chatDao;

    public String findAllChat(){
        String chatListByHtml = "";
        List<Chat> chatList = chatDao.findAllChat();
        if(chatList != null) {
            for (Chat chat : chatList) {
                chatListByHtml += "<tr><td>" + chat.getChatUser();
                chatListByHtml += "</td><td>" + chat.getChatTime() + "</td><td>" + chat.getChatText();
                chatListByHtml += "</td></tr>";
            }
        }
        if(chatListByHtml != null || chatListByHtml != ""){
            return chatListByHtml;
        }else{
            return "暂无聊天记录";
        }
    }
}
