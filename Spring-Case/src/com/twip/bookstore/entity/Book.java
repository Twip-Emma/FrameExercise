package com.twip.bookstore.entity;

import org.springframework.stereotype.Component;

@Component
public class Book {
//create table book_store_ware(
//	book_id int(20) primary key auto_increment,
//	book_name varchar(255),
//	book_price int(255),
//	book_amount int(255)
//)
    private int bookId;
    private String bookName;
    private int bookPrice;
    private int bookAmount;
    private boolean bookFlag;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }

    public boolean isBookFlag() {
        return bookFlag;
    }

    public void setBookFlag(boolean bookFlag) {
        this.bookFlag = bookFlag;
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
