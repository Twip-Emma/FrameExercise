package container;

public class BookInfo {
    private String bookName;
    private int bookPrice;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String show() {
        return "BookInfo{" +
                "bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
