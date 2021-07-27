package com.twip.bookstore.web;

import com.twip.bookstore.config.TxConfig;
import com.twip.bookstore.dao.AdminDao;
import com.twip.bookstore.entity.Book;
import com.twip.bookstore.entity.User;
import com.twip.bookstore.service.AdminService;
import com.twip.bookstore.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
    public static void main(String[] args) {
        System.out.println("暂无，请自行运行下面的测试单元");
    }

    //登录测试
    @Test
    public void text(){
        User cv = context.getBean("user", User.class);
        UserService service = context.getBean("userService",UserService.class);
        cv.setUserAccount("1157529280");
        cv.setUserPassword("82991400");
        cv.setUserName("七画一只妖");
        service.newUser(cv);
    }

    //登录验证测试
    @Test
    public void text2(){
        UserService service = context.getBean("userService",UserService.class);
        service.loginCheck("1157529280");
    }

    //浏览书店列表测试
    @Test
    public void text3(){
        UserService service = context.getBean("userService",UserService.class);
        service.showBookList();
    }

    //添加书本测试
    @Test
    public void text4(){
        AdminService adminService = context.getBean("adminService",AdminService.class);
        Book book = context.getBean("book", Book.class);
        book.setBookName("画镜魔法指南入门");
        book.setBookPrice(35);
        adminService.insertBook(book);
    }
}
