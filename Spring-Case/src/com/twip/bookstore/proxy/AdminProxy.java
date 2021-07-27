package com.twip.bookstore.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
@Order(1)
public class AdminProxy {
    @Pointcut(value = "execution(* com.twip.bookstore.dao.*.*(..))")
    public void pointDemo(){};

    @Before(value = "pointDemo()")
    public void adminUpdateDatabaseBefore(){
        System.out.println("运行管理员对数据库操作的方法之前进行的操作");
    }
}
