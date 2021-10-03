package com.example.springbootcasechat.controller;

import com.example.springbootcasechat.entity.User;
import com.example.springbootcasechat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    User user;

    @RequestMapping("/")
    public String hello(){return "index";}

    @PostMapping("/userTryLogin")
    public String userLogin(@RequestParam("card")String userCard,
                            @RequestParam("password")String userPass,
                            HttpSession session, Model model){
        session.setAttribute("userCard",userCard);
        session.setAttribute("password",userPass);

        user.setUserCard(userCard);
        user.setUserPass(userPass);
        if(loginService.loginCheck(user)){
            return "redirect:/chat/goToChat";
        }else{
            model.addAttribute("msg","通行证与密码不匹配");
            return "index";
        }

    }
}
