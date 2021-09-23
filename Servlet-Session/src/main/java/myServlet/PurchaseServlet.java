package myServlet;

import database.BookDB;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        if(id == null){
            String url = "/ListBookServlet";
            resp.sendRedirect(url);
            return;
        }
        Book book = BookDB.getBook(id);

        HttpSession session = req.getSession();//获取请求域
        List<Book> bookList = (List) session.getAttribute("bookList");
        if(bookList == null){
            bookList = new ArrayList<>();
            session.setAttribute("bookList",bookList);
        }

        bookList.add(book);

        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60 * 30);
        cookie.setPath("/Servlet_Session_war");
        resp.addCookie(cookie);

        String url = "/Servlet_Session_war/CartServlet";
        resp.sendRedirect(url);
    }
}
