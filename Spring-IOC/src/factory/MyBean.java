package factory;

import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean<Book2> {

    //定义返回Bean
    @Override
    public Book2 getObject() throws Exception {
        Book2 book = new Book2();
        book.setName("易筋经");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
