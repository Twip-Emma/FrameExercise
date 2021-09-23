package myServlet;

import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        List<Book> cart = null;//初始化购物车
        boolean putFlag = true;//判断是否买过物品

        HttpSession session = req.getSession(false);
        if(session == null){
            putFlag = false;
        }else{
            cart = (List<Book>) session.getAttribute("bookList");
            if(cart == null){
                putFlag = false;
            }
        }

        if(!putFlag){
            out.print("你怎么不买东西？");
        }else{
            out.write("您购买的图书有：<br />");
            double price = 0;
            for(Book book:cart){
                out.write(book.getName() + "<br />");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
