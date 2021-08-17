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

    public Boolean insertNewBook(Book book){
        if(repeatBookCheck(book.getBookName())){
            Boolean re = bookModel.moreBook(book.getBookName(),book.getBookAmount());
            if(re){
                return true;
            }else{
                return false;
            }
        }else{
            bookModel.insertNewBook(book);
            return true;
        }
    }

    public Boolean deleteBook(String id){
        Boolean re = bookModel.deleteBook(id);
        if(re){
            return true;
        }else{
            return false;
        }
    }

    private Boolean repeatBookCheck(String bookName){
        List<Book> bookList = bookModel.findAll();
        Boolean flag = false;
        for(Book book:bookList){
            if(book.getBookName().equals(bookName)){
                flag = true;
            }
        }
        if(flag){
            return true;
        }else{
            return false;
        }
    }
}
