package com.example.springbootcasechat.entity;

import lombok.Data;

@Data
public class Chat {
    private String chatId;
    private String chatTime;
    private String chatUser;
    private String chatText;
    private String adminType;
    private String roomId;
}
