import com.aop.user.User;
import config.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    @Test
    public void test1(){
        //五种通知类型测试（xml方法）
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User cv = context.getBean("user", User.class);
        cv.add();
    }

    @Test
    public void test2(){
        //五种通知类型测试（配置类方法）
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBean.class);
        User cv = context.getBean("user", User.class);
        cv.add();
    }
}
