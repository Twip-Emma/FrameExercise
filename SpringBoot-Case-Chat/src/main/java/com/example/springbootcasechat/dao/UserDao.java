package com.example.springbootcasechat.dao;

import com.example.springbootcasechat.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    @Results(id = "findUser",
            value = {
                    @Result(id = true,column = "user_id",property = "userId"),
                    @Result(column = "user_card",property = "userCard"),
                    @Result(column = "user_pass",property = "userPass"),
                    @Result(column = "user_exp",property = "userExp"),
                    @Result(column = "user_name",property = "userName")
            })
    List<User> findAllUser();

    @ResultMap(value = "findUser")
    @Insert("insert into user values(#{userId},#{userCard},#{userPass},0,#{userName})")
    void creatNewUser(String userId,String userCard,String userPass,String userName);

    @ResultMap(value = "findUser")
    @Select("select * from user where user_card=#{userCard}")
    User findUser(String userCard);

    @ResultMap(value = "findUser")
    @Update("update user set user_name=#{userName} where user_card=#{userCard}")
    void changeUserName(String userName,String userCard);
}
