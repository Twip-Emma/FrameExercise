package com.example.springbootcasechat.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private String userId;
    private String userCard;
    private String userPass;
    private Integer userExp;
    private String userName;
}
