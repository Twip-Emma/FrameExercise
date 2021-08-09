package com.example.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/aaa")
    public String helloController(){
        return "给老子爬！！";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("name","<h1>七画一只妖</h1>");
        map.put("users", Arrays.asList("哦豁","冷姐","富贵"));
        return "success";
    }
}
