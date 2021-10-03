package com.example.springbootcasechat.entity;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String userCard;
    private String userPass;
    private Integer userExp;
    private String userName;
}
