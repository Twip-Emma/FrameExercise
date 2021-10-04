package com.example.springbootcasechat.controller;

import com.example.springbootcasechat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private String HTML_HEADER="<table><tr><th>发言人</th><th>发言时间</th><th>内容</th>";
    private String HTML_TAIL="</tr></table>";

    @Autowired
    ChatService chatService;

    @RequestMapping("/goToChat")
    public String startChat(Model model){
        String allChat = chatService.findAllChat();
        String htmlFinal = HTML_HEADER + allChat + HTML_TAIL;
        model.addAttribute("chatMsg",htmlFinal);
        return "chat";
    }

    @PostMapping("/send")
    public String userSend(@RequestParam("chattext")String chatText,
                           HttpSession session,
                           Model model){
        chatService.newChat(chatText,session);
        return "redirect:/chat/goToChat";
    }
}
