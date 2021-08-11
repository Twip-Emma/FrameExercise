package com.example.springbootcase1.controller;

import com.example.springbootcase1.entity.Book;
import com.example.springbootcase1.service.BookService;
import com.example.springbootcase1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/findAll")
    public String findAll(Map<String,Object> maps){
        String msg = userService.findAll();
        maps.put("users",msg);
        return "user_info";
    }

//    @GetMapping("/findAll2")
//    public Object findAll(){
//        List<Book> bookList = bookService.findAll();
//        return bookList;
//    }
}
