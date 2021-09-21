package main.java.myServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
////        super.service(req, res);
//        res.setCharacterEncoding("utf-8");
//        req.setCharacterEncoding("utf-8");
//        PrintWriter out = res.getWriter();
//        out.println("我叼你妈的？");
//    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        super.doGet(req, resp);
//        resp.setContentType("text/html");
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
//        String name = (String) req.getParameter("name");
//        System.out.println(name);
//
//        PrintWriter out = resp.getWriter();
//        out.println("这是Get");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        System.out.println(name);
        PrintWriter out = resp.getWriter();
        out.println("我是 " + name);
    }

    // 定时跳转
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("3秒后跳转百度");
        resp.setHeader("Refresh","3;URL=https://www.baidu.com");
    }


}
