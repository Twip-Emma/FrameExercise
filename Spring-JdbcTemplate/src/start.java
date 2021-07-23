import com.twip.bookstore.entity.Book;
import com.twip.bookstore.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class start {
    public static void main(String[] args) {
        System.out.println("芜湖起飞");
    }
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setBook_id("001");
        book.setBook_name("易筋经");
        book.setBook_price(999);
        bookService.addBook(book);
    }
}
