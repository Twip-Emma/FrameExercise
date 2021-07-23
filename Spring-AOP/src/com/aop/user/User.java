package com.aop.user;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class User {
    public void add(){
        System.out.println("一。。。");
    }
}
