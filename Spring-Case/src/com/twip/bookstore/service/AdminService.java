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
        Boolean re = adminDao.insertBook(book);
        if(re){
            System.out.println("这是一本新的书，已自动添加");
        }else{
            System.out.println("仓库已存在这本书，已自动总数+1");
        }
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
