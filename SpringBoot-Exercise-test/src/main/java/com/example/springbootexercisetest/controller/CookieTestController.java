package com.example.springbootexercisetest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/6 10:24
 */
@RestController
public class CookieTestController {

    @RequestMapping(value = "/showtime")
    public String showTime(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String lastAccessTime = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lastAccess".equals(cookie.getName())) {
                    lastAccessTime = cookie.getValue();
                }
            }
        }
        String msg = null;
        if (lastAccessTime == null){
            msg = "你是首次访问本站";
        }else{
            msg = "你上次访问的时间是" + lastAccessTime;
        }
        String nowTime = new SimpleDateFormat("yyyy-MM-dd|hh:mm:ss").format(new Date());
        Cookie cookie = new Cookie("lastAccess", nowTime);
        cookie.setMaxAge(10);//设置cookies有效时间（秒）
        response.addCookie(cookie);
        return msg;
    }
}
