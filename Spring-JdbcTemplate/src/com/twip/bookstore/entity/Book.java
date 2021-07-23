package com.twip.bookstore.entity;

public class Book {
    private String book_id;
    private String book_name;
    private int book_price;

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setBook_price(int book_price) {
        this.book_price = book_price;
    }

    public String getBook_id() {
        return book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public int getBook_price() {
        return book_price;
    }
}
