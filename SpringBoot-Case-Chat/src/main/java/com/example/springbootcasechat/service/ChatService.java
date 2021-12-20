package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.ChatDao;
import com.example.springbootcasechat.entity.Chat;
import com.example.springbootcasechat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Component
public class ChatService {
    ChatDao chatDao;
    UserService userService;

    @Autowired
    public ChatService(ChatDao chatDao, UserService userService) {
        this.chatDao = chatDao;
        this.userService = userService;
    }

    public String findAllChat(){
        String chatListByHtml = "";
        List<Chat> chatList = chatDao.findAllChat();
        if(chatList != null) {
            for (Chat chat : chatList) {
                String userName = userService.findUserName(chat.getChatUser());
                chatListByHtml += "<tr><td>" + userName;
                chatListByHtml += "</td><td>" + chat.getChatTime() + "</td><td>" + chat.getChatText();
                chatListByHtml += "</td></tr>";
            }
        }
        if(!chatListByHtml.equals("")){
            return chatListByHtml;
        }else{
            return "暂无聊天记录";
        }
    }

    public void newChat(String chatText, HttpSession session){
        Date data1 = new Date();
        String nowTime = new Date().toString();
        String userCard = (String) session.getAttribute("userCard");
        String chatId = nowTime + userCard;
//        for(int i = 0;i < 10000;i++) {
            chatDao.newChat(chatId, nowTime, userCard, chatText, "pass");
            userService.userGetExp(userCard);
//        }
        Date data2 = new Date();
        System.out.printf("耗时%d毫秒",data2.getTime()-data1.getTime());
    }
}
