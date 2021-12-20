package com.example.springbootcasechat.controller;

import com.example.springbootcasechat.service.ChatService;
import com.example.springbootcasechat.service.RoomService;
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
    private final RoomService roomService;

    @Autowired
    public ChatController(ChatService chatService,RoomService roomService) {
        this.chatService = chatService;
        this.roomService = roomService;
    }

    @RequestMapping("/goToChat")
    public String startChat(Model model,HttpSession session){
        String allChat = chatService.findAllChat(session);
        String htmlFinal = HTML_HEADER + allChat + HTML_TAIL;
        Integer startChatHead = chatService.getStartChatHead(session);
        session.setAttribute("ChatHead",startChatHead);
        model.addAttribute("chatMsg",htmlFinal);

        //获取房间名称
        String roomid = (String) session.getAttribute("roomid");
        if(roomid.equals("公共频道")){
            model.addAttribute("roomid","公共频道");
        }else{
            String roomName = roomService.findRoomNameById(roomid);
            model.addAttribute("roomid",roomName);
        }
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
        if(chatHead + 20 > chatService.getStartChatHead(session) + 20){
            model.addAttribute("chatLimitMsg","没有再新的消息了");
            String allChat = chatService.findAllChat(session);
            String htmlFinal = HTML_HEADER + allChat + HTML_TAIL;
            Integer startChatHead = chatService.getStartChatHead(session);
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
