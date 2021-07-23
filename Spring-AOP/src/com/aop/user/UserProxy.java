package com.aop.user;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class UserProxy {
    //相同切入点抽取
    @Pointcut(value = "execution(* com.aop.user.*.*(..))")
    public void pointDemo(){}

    //前置通知
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("画。。。");
    }

    //后置通知
    @After(value = "pointDemo()")
    public void after(){
        System.out.println("只。。。");
    }

    //异常通知
    @AfterThrowing(value = "pointDemo()")
    public void afterThrowing(){
        System.out.println("AfterThrowing。。。");
    }

    //环绕通知
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("七。。。");
        proceedingJoinPoint.proceed();
        System.out.println("妖。。。");
    }
}
