package com.example.springbootcasechat.service;

import com.example.springbootcasechat.dao.ChatDao;
import com.example.springbootcasechat.entity.Chat;
import com.example.springbootcasechat.entity.User;
import com.example.springbootcasechat.tool.GetChatLimit;
import com.example.springbootcasechat.tool.GetUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;

@Component
public class ChatService {
    private final ChatDao chatDao;
    private final UserService userService;
    private final GetUUID getUUID;
    private final GetChatLimit getChatLimit;

    @Autowired
    public ChatService(ChatDao chatDao, UserService userService, GetUUID getUUID, GetChatLimit getChatLimit) {
        this.chatDao = chatDao;
        this.userService = userService;
        this.getUUID = getUUID;
        this.getChatLimit = getChatLimit;
    }

    public String findAllChat(){
        String chatListByHtml = "";
        List<Chat> chatList = null;
        chatList = chatDao.findAllChat();
        if(chatList.size() > 20){
            chatList = getChatLimit.getChatTail();
        }
        return getString(chatListByHtml, chatList);
    }

    public void newChat(String chatText, HttpSession session){
        String nowTime = new Date().toString();
        String userCard = (String) session.getAttribute("userCard");
        String uuid = getUUID.getChatUUID();
        chatDao.newChat(uuid, nowTime, userCard, chatText, "pass");
            userService.userGetExp(userCard);
    }

    public String findLimitChat(HttpSession session){
        String chatListByHtml = "";
        List<Chat> chatList = null;
        chatList = chatDao.findAllChat();
        Integer chatHead = (Integer)session.getAttribute("ChatHead");
        if(chatList.size() + 20 >= chatHead){
            chatList = getChatLimit.getChatTarget(session);
        }

        return getString(chatListByHtml, chatList);
    }

    private String getString(String chatListByHtml, List<Chat> chatList) {
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

    public Integer getStartChatHead(){
        List<Chat> allChat = chatDao.findAllChat();
        int size = allChat.size();
        int i = size;
        if(size >= 20){
            i = size - 20;
        }
        return i;
    }
}
