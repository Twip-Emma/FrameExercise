package com.example.springbootcase1.controller;

import com.example.springbootcase1.entity.Book;
import com.example.springbootcase1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/userLogin")
    public String login(@RequestParam("passWord") String passWord,
                        @RequestParam("userCard") String userCard,
                        Map<String, Object> map, HttpSession session) {
        System.out.println("进入此方法");
        if (!StringUtils.isEmpty(userCard) && passWord.equals("82991400")) {
            //登陆成功，防止表单重复提交，可以重定向到主页
//            session.setAttribute("loginUser",pass);
            session.setAttribute("loginUser",userCard);
            List<Book> bookList = bookService.findAll();
            String msg = "";
            for(Book o:bookList){
                msg = msg + "<p>书本ID" + o.getBookId() + "||《" + o.getBookName() + "》" + "价格" + o.getBookPrice();
                msg += "元||（剩余" + o.getBookAmount() + "本）</p>";
            }
            map.put("books",msg);
            //防止表单重复提交
            return "redirect:/success.html";
        } else {
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
//    @RequestMapping("/")
//    public String start(){
//        return "login";
//    }
}
