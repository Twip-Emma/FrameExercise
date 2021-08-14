package com.example.springbootcase1.controller;

import com.example.springbootcase1.entity.Book;
import com.example.springbootcase1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//@RestController
@Controller
@RequestMapping("/store")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/findAll")
    public String findAll(Map<String, Object> map){
        List<Book> bookList = bookService.findAll();
        String msg = "";
        for(Book o:bookList){
            msg = msg + "<p>书本ID" + o.getBookId() + "||《" + o.getBookName() + "》" + "价格" + o.getBookPrice();
            msg += "元||（剩余" + o.getBookAmount() + "本）</p>";
        }
        map.put("books",msg);
        return "success";
    }
}
