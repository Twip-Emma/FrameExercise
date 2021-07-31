package com.twip.mybatis.web;

import com.twip.mybatis.config.TxConfig;
import com.twip.mybatis.dao.BookDao;
import com.twip.mybatis.entity.Book;
import com.twip.mybatis.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

public class Start {
    ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

    @Test
    public void test1() throws IOException {
        //查询所有书本测试
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> bookList = bookService.getAll();
        for (Object o : bookList) {
            System.out.println(o);
        }
    }

    @Test
    public void test2() throws IOException{
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = context.getBean("book",Book.class);
        book.setBookName("高维魔法入门");
        book.setBookPrice(80);
        book.setBookAmount(1);
        bookService.addBook(book);
    }
}
