package myServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastAccessServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String lastAccessTime = null;
        Cookie[] cookies = req.getCookies();
        for(int i=0;i<cookies.length && cookies!=null;i++){
            if("lastAccess".equals(cookies[i].getName())){
                //如果cookie名称是lastAccess，则获取这个的值
                lastAccessTime = cookies[i].getValue();
                break;
            }
        }

        if(lastAccessTime == null){
            resp.getWriter().print("<h1>这是你首次访问网站！！！<h1>");
        }else{
            resp.getWriter().print("<h1>你上次访问的时间是：" + lastAccessTime + "<h1>");
        }

        String currentTime = new SimpleDateFormat("yyyy年MM月dd日：hh时mm分ss秒").format(new Date());

        Cookie cookie = new Cookie("lastAccess",currentTime);

        //发送Cookie
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
