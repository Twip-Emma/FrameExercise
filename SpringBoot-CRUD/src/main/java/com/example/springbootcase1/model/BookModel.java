package com.example.springbootcase1.model;

import com.example.springbootcase1.dao.BookDao;
import com.example.springbootcase1.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookModel {
    @Autowired
    private BookDao bookDao;

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public void insertNewBook(Book book){
        bookDao.insertNewBook(book);
    }

    public Boolean deleteBook(String id){return bookDao.deleteBook(id);}

    public Boolean moreBook(String bookName,Integer bookAmount){return bookDao.moreBook(bookName,bookAmount);}
}
