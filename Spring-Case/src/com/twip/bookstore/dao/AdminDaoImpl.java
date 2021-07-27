package com.twip.bookstore.dao;

import com.twip.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //添加书
    @Override
    public Boolean insertBook(Book book) {
        String sql = "insert into book_store_ware values(?,?,?,?)";
        Object[] args = {null, book.getBookName(), book.getBookPrice(), 1};
        int insert = jdbcTemplate.update(sql, args);
        System.out.println("添加成功,影响行数：" + insert);
        return true;
    }

    //删除书
    @Override
    public Boolean deleteBook(Book book) {
        String sql = "delete from book_store_ware where book_id=?";
        Object[] args = {book.getBookId()};
        int insert = jdbcTemplate.update(sql, args);
        System.out.println("删除成功,影响行数：" + insert);
        return true;
    }

    //批量添加相同书
    @Override
    public Boolean insertBookBatch(Book book, int amount) {
        String sql = "update book_store_ware set book_amount=book_amount+? where book_id=?";
        Object[] args = {book.getBookAmount(),amount};
        int update = jdbcTemplate.update(sql,args);
        System.out.println("添加成功,影响行数：" + update);
        return true;
    }
}
