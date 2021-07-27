package com.twip.bookstore.dao;

import com.twip.bookstore.entity.Book;

public interface AdminDao {
    //书本入库
    public Boolean insertBook(Book book);

    //书本删除
    public Boolean deleteBook(Book book);

    //书本批量入库
    public Boolean insertBookBatch(Book book,int amount);
}
