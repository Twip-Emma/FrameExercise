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

    public String findAll(){
        List<Book> bookList = bookModel.findAll();
        String msg = "";
        for(Book o:bookList){
            msg = msg + "<p>书本ID" + o.getBookId() + "||《" + o.getBookName() + "》" + "价格" + o.getBookPrice();
            msg += "元||（剩余" + o.getBookAmount() + "本）</p>";
        }
        return msg;
    }

    public void insertNewBook(Book book){
        bookModel.insertNewBook(book);
    }
}
