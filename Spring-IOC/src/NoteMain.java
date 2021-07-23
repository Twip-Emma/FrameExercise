import annotation.note.service.NoteUser;
import config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NoteMain {
    ApplicationContext context = new ClassPathXmlApplicationContext("note1.xml");

    @Test
    public void test1(){
        //对象创建，属性注入
        NoteUser cv = context.getBean("noteUser", NoteUser.class);
        System.out.println(cv);
        cv.add();
    }

    @Test
    public void test2(){
        //完全注解开发测试，配置类测试
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        NoteUser cv = context.getBean("noteUser", NoteUser.class);
        System.out.println(cv);
        cv.add();
    }
}
