package com.twip.bookstore.dao;

import com.twip.bookstore.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);


    void updateBook(Book book);

    void deleteBook(String id);

    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllBook();

    void batchAddBook(List<Object[]> bookArgs);

    void batchUpdateBook(List<Object[]> bookArgs);

    void batchDeleteBook(List<Object[]> bookArgs);
}
