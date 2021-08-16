package com.example.springbootcase1.controller;

import com.example.springbootcase1.entity.Book;
import com.example.springbootcase1.entity.User;
import com.example.springbootcase1.service.BookService;
import com.example.springbootcase1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private Book book;

    @GetMapping("/users")
    public String  list(Model model){
        String userList = bookService.findAll();
        //放在请求域中
        model.addAttribute("users",userList);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "user/list";
    }

    @PostMapping("/insertNewBook")
    public String insertNewBook(
            @RequestParam("bookName") String bookName,
            @RequestParam("bookPrice") Integer bookPrice,
            @RequestParam("bookAmount") Integer bookAmount,
            Model model){

        book.setBookId(null);
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setBookAmount(bookAmount);
        bookService.insertNewBook(book);

        String userList = bookService.findAll();
        //放在请求域中
        model.addAttribute("users",userList);
        model.addAttribute("msg","插入成功，请刷新页面");
        return "user/list";
    }

}
