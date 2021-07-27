package com.twip.bookstore.service;

import com.twip.bookstore.dao.AdminDao;
import com.twip.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(timeout = 2)
public class AdminService {
    @Autowired
    AdminDao adminDao;

    //服务层-书籍添加
    public void insertBook(Book book){
        adminDao.insertBook(book);
    }

    //服务层-书籍删除
    public void deleteBook(Book book){
        adminDao.deleteBook(book);
    }

    //服务层-书籍批量添加
    public void insertBookBatch(Book book,int amount){
        adminDao.insertBookBatch(book,amount);
    }
}
