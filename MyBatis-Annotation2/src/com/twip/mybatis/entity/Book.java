package com.twip.mybatis.entity;

import org.springframework.stereotype.Component;

@Component
public class Book {
    //create table book_store_ware(
//	book_id int(20) primary key auto_increment,
//	book_name varchar(255),
//	book_price int(255),
//	book_amount int(255)
//)
    private Integer bookId;
    private String bookName;
    private Integer bookPrice;
    private Integer bookAmount;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(Integer bookAmount) {
        this.bookAmount = bookAmount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookAmount=" + bookAmount +
                '}';
    }
}
