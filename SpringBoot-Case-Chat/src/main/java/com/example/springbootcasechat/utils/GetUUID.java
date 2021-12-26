package com.example.springbootcasechat.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author: 七画一只妖
 * @Date: 2021/12/20 9:34
 */
@Component
public class GetUUID {
    public String getUserUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "userid");
        return uuidStr;
    }

    public String getChatUUID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "chat");
        return uuidStr;
    }
    public String getRoomUUID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "room");
        return uuidStr;
    }

}
