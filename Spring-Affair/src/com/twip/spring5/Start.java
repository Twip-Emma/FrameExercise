package com.twip.spring5;

import com.twip.spring5.config.TxConfig;
import com.twip.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    @Test
    public void test1(){
        //事务环境测试(XML)
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService cv = context.getBean("userService",UserService.class);
        cv.accountMoney();
    }

    @Test
    public void test2(){
        //事务环境测试(配置类完全注解开发)
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService cv = context.getBean("userService",UserService.class);
        cv.accountMoney();
    }
}
