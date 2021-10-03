package com.example.springbootcasechat.controller;

import com.example.springbootcasechat.entity.User;
import com.example.springbootcasechat.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    User user;

    @Autowired
    RegisterService registerService;

    @RequestMapping("/")
    public String startRegister(){
        return "register";
    }

    @PostMapping("/userTryRegister")
    public String newUser(@RequestParam("card")String userCard,
                          @RequestParam("password")String userPass,
                          @RequestParam("username")String userName,
                          Model model){
        user.setUserCard(userCard);
        user.setUserPass(userPass);
        user.setUserName(userName);
        if(registerService.creatNewUser(user))
        {
            model.addAttribute("msg","注册成功，请重新登陆！");
            return "redirect:/user/";
        }else{
            model.addAttribute("msg","此通行证已被注册，请重试");
            return "register";
        }
    }
}
