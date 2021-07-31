package com.twip.mybatis.service;

import com.twip.mybatis.dao.BookDao;
import com.twip.mybatis.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookService {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "com/twip/mybatis/config/config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    public List<Book> getAll() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            BookDao mapper = openSession.getMapper(BookDao.class);
            List<Book> bookList = mapper.findAll();
            return bookList;
        }finally {
            openSession.close();
        }
    }

    public void addBook(Book book) throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            BookDao mapper = openSession.getMapper(BookDao.class);
            mapper.addBook(book);
            openSession.commit();
        }finally {
            openSession.close();
        }
    }
}
