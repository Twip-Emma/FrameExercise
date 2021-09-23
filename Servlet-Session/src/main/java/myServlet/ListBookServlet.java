package myServlet;

import database.BookDB;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class ListBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        Collection<Book> books = BookDB.getAll();
        out.write("本站的图书有：<br />");
        for(Book book : books){
            String url = "/Servlet_Session_war/PurchaseServlet?id=" + book.getId();
            out.write(book.getName() + "<a href='" + url + "'>点击购买</a><br />");
        }
    }
}
