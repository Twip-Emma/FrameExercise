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
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @RequestMapping("/goToChat")
    public String startChat(Model model,HttpSession session){
        String allChat = chatService.findAllChat();
        String htmlFinal = HTML_HEADER + allChat + HTML_TAIL;
        Integer startChatHead = chatService.getStartChatHead();
        session.setAttribute("ChatHead",startChatHead);
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

    @RequestMapping("/goChatUp")
    public String goChatUp(HttpSession session,Model model){
        Integer chatHead = (Integer) session.getAttribute("ChatHead");
        chatHead -= 1;
        if(chatHead <= -1){
            model.addAttribute("chatLimitMsg","没有更早的消息了");
            session.setAttribute("ChatHead",chatHead + 1);
            String allChat = chatService.findLimitChat(session);
            String htmlFinal = HTML_HEADER + allChat + HTML_TAIL;
            model.addAttribute("chatMsg",htmlFinal);
            return "chat";
        }else{
            session.setAttribute("ChatHead",chatHead);
            String allChat = chatService.findLimitChat(session);
            String htmlFinal = HTML_HEADER + allChat + HTML_TAIL;
            model.addAttribute("chatMsg",htmlFinal);
            return "chat";
        }
    }

    @RequestMapping("/goChatDown")
    public String goChatDown(HttpSession session,Model model){
        Integer chatHead = (Integer) session.getAttribute("ChatHead");
        chatHead += 1;
        if(chatHead + 20 > chatService.getStartChatHead() + 20){
            model.addAttribute("chatLimitMsg","没有再新的消息了");
            String allChat = chatService.findAllChat();
            String htmlFinal = HTML_HEADER + allChat + HTML_TAIL;
            Integer startChatHead = chatService.getStartChatHead();
            session.setAttribute("ChatHead",startChatHead);
            model.addAttribute("chatMsg",htmlFinal);
        }else{
            session.setAttribute("ChatHead",chatHead);
            String allChat = chatService.findLimitChat(session);
            String htmlFinal = HTML_HEADER + allChat + HTML_TAIL;
            model.addAttribute("chatMsg",htmlFinal);
            return "chat";
        }
        return "chat";
    }
}
