package com.example.springbootcasechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class _AutoController {
    @GetMapping("/register")
    private String _goToRegister(){
        return "register";
    }
}
