package com.example.springbootcase1.controller;

import com.example.springbootcase1.entity.Book;
import com.example.springbootcase1.service.BookService;
import com.example.springbootcase1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    //    @RequestMapping("/userLogin")
//    @ResponseBody
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @PostMapping("/userLogin")
    public String login(@RequestParam("passWord") String passWord,
                        @RequestParam("userCard") String userCard,
                        Model model, HttpSession session) {
        if (userService.findUserPass(userCard,passWord)) {
            //登陆成功，防止表单重复提交，可以重定向到主页

            session.setAttribute("loginUser",userCard);


//            model.addAttribute("books",msg);
            //防止表单重复提交
            System.out.println("密码对了");
            return "redirect:/main.html";
        } else {
//            map.put("msg","用户名或密码错误");
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
//    @RequestMapping("/")
//    public String start(){
//        return "login";
//    }
}
