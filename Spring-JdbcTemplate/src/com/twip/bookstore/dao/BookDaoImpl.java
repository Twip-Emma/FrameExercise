package com.twip.bookstore.dao;

import com.twip.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //添加的方法
    @Override
    public void add(Book book) {
        String sql = "insert into book_info values(?,?,?)";
        Object[] args = {book.getBook_id(),book.getBook_name(),book.getBook_price()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }
}
