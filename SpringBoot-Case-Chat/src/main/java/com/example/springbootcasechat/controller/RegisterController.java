package com.example.springbootcasechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @RequestMapping("/")
    public String startRegister(){
        return "register";
    }

    @PostMapping("/userTryRegister")
    public String newUser(@RequestParam("card")String userCard,
                          @RequestParam("password")String userPass,
                          @RequestParam("username")String userName){
        return "index";
    }
}
