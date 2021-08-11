package com.example.springbootcase1.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
    //  user_id int(20) primary key auto_increment,
//	user_account varchar(255),
//	user_password varchar(255),
//	user_name varchar(255),
//	user_vip int(10),
//	user_balance int(255),
    private int userId;
    private String userAccount;
    private String userPassword;
    private String userName;
    private int userVip;
    private int userBalance;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserVip() {
        return userVip;
    }

    public void setUserVip(int userVip) {
        this.userVip = userVip;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPassWord='" + userPassword + '\'' +
                ", userName='" + userName + '\'' +
                ", userVip=" + userVip +
                ", userBalance=" + userBalance +
                '}';
    }
}
