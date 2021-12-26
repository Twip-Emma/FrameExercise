package com.example.springbootcasechat.controller;

import com.example.springbootcasechat.service.CreatRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/20 16:47
 */
@Controller
@RequestMapping("/creatRoom")
public class CreatRoomController {
    private final CreatRoomService creatRoomService;

    public CreatRoomController(CreatRoomService creatRoomService) {
        this.creatRoomService = creatRoomService;
    }

    @GetMapping("/newRoom")
    public String newRoom(HttpSession session,
                          @RequestParam("roomname")String roomName,
                          Model model){
        String userCard = (String) session.getAttribute("userCard");
        creatRoomService.creatNewRoom(roomName,userCard);
        model.addAttribute("msg", "创建房间成功");

        return "redirect:/user/goToUser";
    }
}
