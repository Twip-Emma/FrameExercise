import com.twip.bookstore.entity.Book;
import com.twip.bookstore.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class start {
    public static void main(String[] args) {
        System.out.println("芜湖起飞");
    }
    ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    @Test
    public void test1(){
        //数据库增加操作测试
        Book book = new Book();
        book.setBook_id("002");
        book.setBook_name("易筋经");
        book.setBook_price(999);
        bookService.addBook(book);
    }

    @Test
    public void test2(){
        //数据库修改操作测试
        Book book = new Book();
        book.setBook_id("001");
        book.setBook_name("武林外传");
        book.setBook_price(666);
        bookService.updateBook(book);
    }

    @Test
    public void test3(){
        //数据库删除操作测试
        bookService.deleteBook("001");
    }

    @Test
    public void test4(){
        //查询（某个值）
        int count = bookService.findCount();
        System.out.println(count);
    }

    @Test
    public void test5(){
        //查询（某个对象）
        int count = bookService.findCount();
        System.out.println(count);
    }

    @Test
    public void test6(){
        //查询（某个集合）
        List<Book> bookList = bookService.findAll();
        System.out.println(bookList);
    }

    @Test
    public void test7(){
        //批量添加
        List<Object[]> bookArgs = new ArrayList<>();
        Object[] o1 = {"003","三国演义",45};
        Object[] o2 = {"004","水浒传",145};
        Object[] o3 = {"005","红楼梦",445};
        bookArgs.add(o1);
        bookArgs.add(o2);
        bookArgs.add(o3);
        bookService.batchAdd(bookArgs);
    }

    @Test
    public void test8(){
        //批量修改
        List<Object[]> bookArgs = new ArrayList<>();
        Object[] o1 = {"三国演义2",666,"003"};
        Object[] o2 = {"水浒传3",555,"004"};
        Object[] o3 = {"红楼梦4",444,"005"};
        bookArgs.add(o1);
        bookArgs.add(o2);
        bookArgs.add(o3);
        bookService.batchUpdate(bookArgs);
    }

    @Test
    public void test9(){
        //批量删除
        List<Object[]> bookArgs = new ArrayList<>();
        Object[] o1 = {"003"};
        Object[] o2 = {"004"};
        bookArgs.add(o1);
        bookArgs.add(o2);
        bookService.batchDelete(bookArgs);
    }
}
