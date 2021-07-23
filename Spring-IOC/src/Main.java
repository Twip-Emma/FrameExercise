import bean.Emp;
import container.BookInfo;
import container.BookStore;
import container.Student;
import factory.Book2;
import factory.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import test.Book;
import test.Orders;
import test.User;

import java.io.IOException;

public class Main {
    public static ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
    public static ApplicationContext context2 = new ClassPathXmlApplicationContext("bean2.xml");
    public static ApplicationContext context3 = new ClassPathXmlApplicationContext("bean3.xml");
    public static ApplicationContext context4 = new ClassPathXmlApplicationContext("bean4.xml");
    public static ApplicationContext context5 = new ClassPathXmlApplicationContext("bean5.xml");
    public static ApplicationContext context6 = new ClassPathXmlApplicationContext("bean6.xml");
    public static void main(String[] args) throws IOException {

        User cv = context.getBean("user",User.class);
        cv.hello();
//        try {
//            return;
////            throw new Exception("出错啦");
//        } catch (Exception e) {
////            e.printStackTrace();
//            System.out.println(e.getMessage());
//
//        }finally {
//            System.out.println("sb");
//        }
        Book cv2 = context.getBean("book",Book.class);
        String msg = cv2.ShowBook();
        System.out.println(msg);

        Orders cv3 = context.getBean("orders",Orders.class);
        cv3.Show();
    }

    @Test
    public void testOrders(){
        //有参构造方法注入属性
        Orders cv3 = context.getBean("orders",Orders.class);
        cv3.Show();
    }

    @Test
    public void orderBean(){
        //注入外部Bean测试
        UserService cv4 = context2.getBean("userService", UserService.class);
        cv4.Show();
    }

    @Test
    public void test5(){
        //内部Bean测试
        Emp cv5 = context3.getBean("emp",Emp.class);
        cv5.show();
    }

    @Test
    public void test6(){
        //级联赋值测试
        Emp cv = context3.getBean("emp2",Emp.class);
        cv.show();
    }

    @Test
    public void test7(){
        //容器的Bean管理
        Student cv = context4.getBean("stu",Student.class);
        System.out.println(cv.show());
    }

    @Test
    public void test8(){
        //对象注入Bean管理
        BookStore cv = context4.getBean("store",BookStore.class);
        System.out.println(cv.show());
    }

    @Test
    public void test9(){
        //命名空间注入测试
        BookStore cv = context5.getBean("utilList",BookStore.class);
        System.out.println(cv.show());
    }

    @Test
    public void test10(){
        //工厂bean测试
        Book2 cv = context6.getBean("myBean", Book2.class);
        System.out.println(cv);
    }

    @Test
    public void test11(){
        //单（多）例Bean测试
        Book cv1 = context6.getBean("book",Book.class);
        Book cv2 = context6.getBean("book",Book.class);
        System.out.println(cv1);
        System.out.println(cv2);
    }

    @Test
    public void test12(){
        //自动装配测试
        Emp cv = context6.getBean("emp",Emp.class);
        System.out.println(cv);
    }
}
