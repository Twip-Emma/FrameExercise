package com.example.springbootcasechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/")
    public String hello(){return "index";}

    @PostMapping("/userTryLogin")
    public String userLogin(@RequestParam("card")String userCard,
                            @RequestParam("password")String userPass,
                            HttpSession session, Model model){
        session.setAttribute("userCard",userCard);
        session.setAttribute("password",userPass);
        if(userCard.equals("七画一只妖") && userPass.equals("8888")){
            return "redirect:/chat/goToChat";
        }else{
            model.addAttribute("msg","通行证与密码不匹配");
            return "index";
        }

    }
}
