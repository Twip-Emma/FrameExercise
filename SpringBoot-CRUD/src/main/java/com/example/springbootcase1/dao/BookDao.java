package com.example.springbootcase1.dao;

import com.example.springbootcase1.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {
    @Select("select * from book_store_ware")
    @Results(id = "bookMap",
            value = {
                    @Result(id = true,column = "book_id",property = "bookId"),
                    @Result(column = "book_name",property = "bookName"),
                    @Result(column = "book_price",property = "bookPrice"),
                    @Result(column = "book_amount",property = "bookAmount"),
            })
    List<Book> findAll();


    @Insert("insert into " +
            "book_store_ware(book_id,book_name,book_price,book_amount)" +
            "value(#{bookId},#{bookName},#{bookPrice},#{bookAmount})")
    void insertNewBook(Book book);
//    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")


}
