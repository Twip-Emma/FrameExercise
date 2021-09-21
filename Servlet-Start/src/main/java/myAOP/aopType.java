package main.java.myAOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.osgi.framework.ServiceException;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class aopType {
    @Before(value = "bean(doGet) && args(req) && execution(* main.java.myServlet.LoginServlet.*(..))", argNames="req")
//    @Before(value = "execution(* main.java.myServlet.LoginServlet.*(..))")
    public void setReq(HttpServletRequest req) throws IOException, ServiceException {
        req.setCharacterEncoding("utf-8");
        System.out.println("进入了前置通知");
    }
}
