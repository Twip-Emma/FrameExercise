package com.aop.user;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Order(1)
public class UserProxy2 {
    @Pointcut(value = "execution(* com.aop.user.*.*(..))")
    public void pointDemo(){}

    @Before(value = "pointDemo()")
    public void beforeFirst(){
        System.out.println("I‘m the first one...");
    }

}
