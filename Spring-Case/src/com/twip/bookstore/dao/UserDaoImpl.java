package com.twip.bookstore.dao;

import com.twip.bookstore.entity.Book;
import com.twip.bookstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //新建用户
    @Override
    public void newUser(User user) {
        String sql = "insert into book_store_user values(?,?,?,?,?,?)";
        Object[] args = {null, user.getUserAccount(), user.getUserPassword(), user.getUserName(), 1, 1000};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    //登录验证
    @Override
    public Boolean loginCheck(String account) {
        String sql = "select * from book_store_user where user_account=?";
        try {
            User re = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), account);
            System.out.println(re);
            return true;
        }catch (Exception e){
//            e.printStackTrace();
            return false;
        }
    }

    //遍历书店
    @Override
    public String showBookList() {
        String sql = "select * from book_store_ware";
        List<Book> bookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
        for(Book book:bookList){
            int bookId = book.getBookId();
            String bookName = book.getBookName();
            int bookPrice = book.getBookPrice();
            int bookAmount = book.getBookAmount();
            System.out.println("《" + bookName + "》售价：" + bookPrice + "元|剩余" + bookId + "本");
        }
        return null;
    }

    @Override
    public Boolean insertBook(String id) {
        return null;
    }

    @Override
    public Boolean settleShop() {
        return null;
    }
}
