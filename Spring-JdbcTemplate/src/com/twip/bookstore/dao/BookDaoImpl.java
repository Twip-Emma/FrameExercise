package com.twip.bookstore.dao;

import com.twip.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

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

    //修改的方法
    @Override
    public void updateBook(Book book) {
        String sql = "update book_info set book_name=?,book_price=? where book_id=?";
        Object[] args = {book.getBook_name(),book.getBook_price(),book.getBook_id()};
        //第一个参数：sql语句
        //第二个参数，数组内顺序对应sql语句里面的?号
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    //删除的方法
    @Override
    public void deleteBook(String id) {
        String sql = "delete from book_info where book_id=?";
        int update = jdbcTemplate.update(sql,id);
        System.out.println(update);
    }

    //查询某个值
    @Override
    public int selectCount() {
        String sql = "select count(*) from book_info";
        //第一个参数：sql语句
        //第二个参数：返回值类型对于的类.class
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    //查询某个对象
    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from book_info where book_id=?";
        //第一个参数：sql语句
        //第二个参数：RowMapper接口，返回不同的类型，使用职工接口里面的实现类完成数据的封装
        //第三个参数，数组内顺序对应sql语句里面的?号
        //BeanPropertyRowMapper<返回的类型>(返回的类型对于的类.class)
        Book book = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
        return book;
    }

    //查询集合
    @Override
    public List<Book> findAllBook() {
        String sql = "select * from book_info";
        List<Book> bookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    //批量添加
    @Override
    public void batchAddBook(List<Object[]> bookArgs) {
        String sql = "insert into book_info values(?,?,?)";
        //类似于上面的Object[] args = {book.getBook_name(),book.getBook_price(),book.getBook_id()};
        //由List封装多个不同的args
        //batchUpdate会遍历这些args一个个执行sql语句
        int[] ints = jdbcTemplate.batchUpdate(sql,bookArgs);
        System.out.println(Arrays.toString(ints));
    }

    //批量修改
    @Override
    public void batchUpdateBook(List<Object[]> bookArgs) {
        String sql = "update book_info set book_name=?,book_price=? where book_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql,bookArgs);
        System.out.println(Arrays.toString(ints));
    }

    //批量删除
    @Override
    public void batchDeleteBook(List<Object[]> bookArgs) {
        String sql = "delete from book_info where book_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql,bookArgs);
        System.out.println(Arrays.toString(ints));
    }
}
