package com.twip.bookstore.proxy;

import com.twip.bookstore.entity.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
@EnableAspectJAutoProxy
@Order(1)
@Transactional(timeout = 2)
public class AdminProxy {
    @Pointcut(value = "execution(* findById(java.lang.String))")
    public void pointDemo(){}

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Before(value = "bean(adminService) && args(book) && execution(* com.twip.bookstore.service.AdminService.insertBook(..))", argNames="book")
    public void adminUpdateDatabaseBefore(Book book){
        System.out.println("欢迎您，管理员");
        String sql = "select * from book_store_ware where book_name=?";
        try {
            Book re = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), book.getBookName());
            String sql2 = "update book_store_ware set book_amount=book_amount+1 where book_name=?";
            Object[] args = {book.getBookName()};
            jdbcTemplate.update(sql2, args);
            book.setBookFlag(true);
        } catch (Exception e) {
            book.setBookFlag(false);
            System.out.println("这是一本新书");
        }
    }

    @Before(value = "bean(adminService) && args(book) && execution(* com.twip.bookstore.service.AdminService.deleteBook(..))", argNames="book")
    public void adminDeleteDatabaseBefore(Book book){
        System.out.println("欢迎您，管理员");
        String sql = "select * from book_store_ware where book_name=?";
        try {
            Book re = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), book.getBookName());
            book.setBookFlag(true);
            System.out.println("代理类：成功找到了这本书");
        } catch (Exception e) {
            book.setBookFlag(false);
            System.out.println("代理类：找不到这本书");
        }
    }

    @Before(value = "bean(adminService) && args(book) && execution(* com.twip.bookstore.service.AdminService.insertBookBatch(..))", argNames="book")
    public void adminUpdateInsertBatchBefore(Book book){
        System.out.println("欢迎您，管理员");
        String sql = "select * from book_store_ware where book_name=?";
        try {
            Book re = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), book.getBookName());
            book.setBookFlag(true);
            System.out.println("代理类：成功找到了这本书");
        } catch (Exception e) {
            book.setBookFlag(false);
            System.out.println("代理类：找不到这本书");
        }
    }
}
