package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        //创建代理对象
        //第一个参数：类加载器
        //第二个参数，想要实现的接口（数组类型）
        //第三个参数，实现接口InvocationHandler创建代理对象，写增强方法
        Class[] interfaces = {UserDao.class};
        UserDaoImpl a = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(a));
        Object msg = dao.update("芜湖");
        System.out.println(msg);
    }
}

class UserDaoProxy implements InvocationHandler {
    private Object obj;

    //1.创建的是谁的代理对象，就把谁传递过来
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //增强的结构
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //原方法前运行
        System.out.println("方法之前执行" + method.getName() + ":传递的参数是" + Arrays.toString(args));

        //运行原方法
        Object res = method.invoke(obj, args);
        //原方法之后运行
        System.out.println("方法之后执行" + obj);

        return res;
    }
}
