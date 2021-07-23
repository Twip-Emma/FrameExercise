package test;

public class Book {
    private String bookName;
    private int price;

    public String ShowBook(){
        return bookName + "::" + price;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
