package com.twip.bookstore.service;

import com.twip.bookstore.dao.BookDao;
import com.twip.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    //数据库添加
    public void addBook(Book book){
        bookDao.add(book);
    }

    //数据库修改
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    //数据库
    public void deleteBook(String id){
        bookDao.deleteBook(id);
    }

    //查询记录数量
    public int findCount(){
        return bookDao.selectCount();
    }

    //查询对象
    public Book findOne(String id){
        return bookDao.findBookInfo(id);
    }

    //查询集合
    public List<Book> findAll(){
        return bookDao.findAllBook();
    }

    //批量添加
    public void batchAdd(List<Object[]> bookArgs){
        bookDao.batchAddBook(bookArgs);
    }

    //批量修改
    public void batchUpdate(List<Object[]> bookArgs){
        bookDao.batchUpdateBook(bookArgs);
    }

    //批量删除
    public void batchDelete(List<Object[]> bookArgs){
        bookDao.batchDeleteBook(bookArgs);
    }
}
