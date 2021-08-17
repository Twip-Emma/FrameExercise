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
        Boolean re = bookService.insertNewBook(book);
        if(re){
            model.addAttribute("msg","插入成功，请刷新页面");
        }else{
            model.addAttribute("msg","插入失败，出现了未知错误");
        }

        String userList = bookService.findAll();
        //放在请求域中
        model.addAttribute("users",userList);

        return "user/list";
    }

    @PostMapping("/deleteBook")
    public String insertNewBook(
            @RequestParam("bookId") String bookId,
            Model model){
        Boolean re = bookService.deleteBook(bookId);
        if(re){
            model.addAttribute("msg","删除成功，请刷新页面");
        }else{
            model.addAttribute("msg","删除失败，未找到你要删除的书目ID");
        }
        String userList = bookService.findAll();
        model.addAttribute("users",userList);
        return "user/list";
    }

}
