package com.example.springbootcasevue;

import com.example.springbootcasevue.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootCaseVueApplicationTests {

    @Autowired
    User user;

    @Test
    void contextLoads() {
        System.out.println(user.getA());
    }

}
