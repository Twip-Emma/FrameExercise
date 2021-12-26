package com.example.springbootcasechat.controller;

import com.example.springbootcasechat.entity.Room;
import com.example.springbootcasechat.service.ChatService;
import com.example.springbootcasechat.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/20 15:29
 */
@Controller
@RequestMapping("/room")
public class RoomController {
    private String HTML_HEADER="<table><tr><th>发言人</th><th>发言时间</th><th>内容</th>";
    private String HTML_TAIL="</tr></table>";

    private final RoomService roomService;
    private final ChatService chatService;

    public RoomController(RoomService roomService,ChatService chatService) {
        this.roomService = roomService;
        this.chatService = chatService;
    }

    //展示所有房间
    @RequestMapping("/showRoom")
    public String showAllRoom(Model model){
        String returnHtml = "";
        List<Room> allRoom = roomService.findAllRoom();
        for(Room room : allRoom){
            returnHtml += "<a href=\"/room/goToRoom?id=" + room.getRoomId() +
                    "\" action=\"@/room/goToRoom?id=" + room.getRoomId() +
                    "\">"+ room.getRoomName() +"</a><br/>";
        }
        model.addAttribute("roomlist",returnHtml);
        return "roomlist";
    }

    //跳转房间
    @GetMapping("/goToRoom")
    public String goToRoom(@RequestParam("id")String roomId,
                           HttpSession session,Model model){
        session.setAttribute("roomid",roomId);
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
}
