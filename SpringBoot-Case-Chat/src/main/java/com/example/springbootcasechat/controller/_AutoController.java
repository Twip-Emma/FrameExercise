package com.example.springbootcasechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class _AutoController {
    @GetMapping("/register")
    private String _goToRegister(){
        return "register";
    }

    @RequestMapping(value = "/")
    public String start(){
        return "redirect:/user/";
    }
}
