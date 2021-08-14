package com.example.springbootcase1.controller;

import com.example.springbootcase1.entity.Book;
import com.example.springbootcase1.service.BookService;
import com.example.springbootcase1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public String findAll(Map<String,Object> maps){
        String msg = userService.findAll();
        maps.put("users",msg);
        return "user_info";
    }
}
