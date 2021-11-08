package com.example.springbootcasevue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class GetInfoController {
    @PostMapping("/newUser")
    public String getDataFromVue(HttpServletRequest request, HttpServletResponse response,@RequestBody String userData) {
        System.out.println(userData);
        System.out.println("成功1");
        String msg = "数据1数据1数据1数据1数据1数据1数据1数据1";
        return msg;
    }

    @GetMapping("/test2")
    public String getDataFromVue2(HttpServletRequest request, HttpServletResponse response, @RequestParam("userData")String userData){
        System.out.println(userData);
        System.out.println("成功2");
        String msg = "数据2数据2数据2数据2数据2数据2数据2数据2";
        return msg;
    }
}
