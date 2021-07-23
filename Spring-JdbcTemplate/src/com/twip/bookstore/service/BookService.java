package com.twip.bookstore.service;

import com.twip.bookstore.dao.BookDao;
import com.twip.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    //数据库添加
    public void addBook(Book book){
        bookDao.add(book);
    }
}
