package com.example.springbootcase1;

import com.example.springbootcase1.entity.Book;
import com.example.springbootcase1.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringBootCase1ApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
        List<Book> bookList = bookService.findAll();
        String msg = "";
        for(Object o:bookList){
            System.out.println(o);
            msg = msg + o.toString() + "\n";
        }
        System.out.println(msg);
        System.out.println(bookList);
    }
}
