package com.twip.mybatis.web;

import com.twip.mybatis.dao.AnnotationMapper;
import com.twip.mybatis.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class start {
    public static void main(String[] args) {
        System.out.println("你好，世界！");
    }

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test1(){
        Book book = new Book();
        book.setBookName("高维魔法入门指南");
        book.setBookPrice(65);

    }
}
