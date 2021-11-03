package com.example.springbootcasevue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class GetInfoController {
    @GetMapping("/testPost")
    public String getDataFromVue(HttpServletRequest request, HttpServletResponse response, @RequestParam("userData")String userData)
        throws IOException
    {
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.addHeader("Access-Control-Allow-Headers", "request.getHeader(“Access-Control-Request-Headers”)");
        response.addHeader("Access-Control-Max-Age", "120");
        System.out.println(userData);
        System.out.println("成功1");
        String msg = "{\"name\":\"张三\"}";
        return msg;
    }

    @PostMapping("/test2")
    public String getDataFromVue2(HttpServletRequest request, HttpServletResponse response,@RequestBody String userData){
//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
//        response.addHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
//        response.addHeader("Access-Control-Max-Age", "120");
        System.out.println(userData);
        System.out.println("成功2");
        String msg = "{name:张三,age:10,school:湖南工程学院}";
        return msg;
    }
}
