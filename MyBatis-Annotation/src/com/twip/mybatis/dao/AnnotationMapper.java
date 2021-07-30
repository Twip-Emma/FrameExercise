package com.twip.mybatis.dao;

import com.twip.mybatis.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AnnotationMapper {
    @Select("select * from book_store_ware")
    @Results(id = "bookMap",
            value = {
            @Result(id = true,column = "book_id",property = "bookId"),
            @Result(column = "book_name",property = "bookName"),
            @Result(column = "book_price",property = "bookPrice"),
            @Result(column = "book_amount",property = "bookAmount"),
    })
    List<Book> findAll();

    @Insert("insert into book_store_ware(book_name,book_price,book_amount)values(#{bookName},#{bookPrice},#{bookAmount})")
    void addBook(Book book);

    @Update("update book_store_ware set book_name=#{bookName},book_price=#{bookPrice},book_amount=#{bookAmount}")
    void updateBook(Book book);

    @Delete("delete from book_store_ware where book_id=#{bookId}")
    void deleteBook(Integer id);

    @ResultMap(value = "bookMap")
    @Select("select * from book_store_ware where book_id=#{bookId} ")
    Book findById(Integer userId);

//    @Select("select * from user where username like #{username} ")
    @ResultMap(value = "bookMap")
    @Select("select * from book_store_ware where book_name like '%${value}%' ")
    List<Book> findBookByName(String username);

    @ResultMap(value = "bookMap")
    @Select("select count(*) from book_store_ware ")
    int findTotalBook();
}
