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

    @Delete("delete from book_store_ware where book_id=#{id}")
    Boolean deleteBook(String id);

    //测试用的方法
    @Delete("delete from book_store_ware where book_id=#{id}")
    Boolean deleteBookReturnBool(String id);

    @Update("update book_store_ware set book_amount=book_amount+#{bookAmount} where book_name=#{bookName}")
    Boolean moreBook(String bookName,Integer bookAmount);
}
