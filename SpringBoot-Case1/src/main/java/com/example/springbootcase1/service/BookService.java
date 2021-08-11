package com.example.springbootcase1.service;

import com.example.springbootcase1.entity.Book;
import com.example.springbootcase1.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {
    @Autowired
    private BookModel bookModel;

    public List<Book> findAll(){
        return bookModel.findAll();
    }
}
