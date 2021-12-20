package com.example.springbootcasechat.controller;

import com.example.springbootcasechat.entity.User;
import com.example.springbootcasechat.service.LoginService;
import com.example.springbootcasechat.service.ToolService;
import com.example.springbootcasechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class LoginController {
    private final LoginService loginService;
    private final UserService userService;
    private final ToolService toolService;
    private final User user;

    @Autowired
    public LoginController(LoginService loginService, UserService userService, ToolService toolService, User user) {
        this.loginService = loginService;
        this.userService = userService;
        this.toolService = toolService;
        this.user = user;
    }

    @RequestMapping("/")
    public String hello(HttpServletRequest request,Model model,
                        HttpSession session) {
        //读取cookies并且判断账号密码是否正确
        Cookie[] cookies = request.getCookies();
        String card = null;
        String pass = null;



        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().compareTo("usercard") == 0){
                    card = cookie.getValue();
                }else if (cookie.getName().compareTo("password") == 0){
                    pass = cookie.getValue();
                }
            }
        }else{
            return "index";
        }
        session.setAttribute("userCard", card);
        session.setAttribute("userPass", pass);
        user.setUserCard(card);
        user.setUserPass(pass);
        if(card == null || pass == null || card.equals("") || pass.equals("")){
            return "index";
        }
        //判断cookies保存的账号密码是否正确
        if (loginService.loginCheck(user)) {
            return "redirect:/chat/goToChat";
        } else {
            model.addAttribute("msg", "通行证与密码不匹配");
            return "index";
        }
    }

    @PostMapping("/userTryLogin")
    public String userLogin(@RequestParam("card") String userCard,
                            @RequestParam("password") String userPass,
                            @RequestParam("check") String userCheck,
                            HttpSession session, Model model,
                            HttpServletResponse response,HttpServletRequest request) {
        String remember = request.getParameter("remember");
        Cookie card;
        Cookie pwd;
        if("on".equals(remember)){
            card = new Cookie("usercard", userCard);
            pwd = new Cookie("password", userPass);
            card.setMaxAge(60*60*24*3);
            pwd.setMaxAge(60*60*24*3);
        }else{
            card = new Cookie("usercard", null);
            pwd = new Cookie("password", null);
            card.setMaxAge(0);
            pwd.setMaxAge(0);
        }
        response.addCookie(card);
        response.addCookie(pwd);

        session.setAttribute("roomid","公共频道");
        session.setAttribute("userCard", userCard);
        session.setAttribute("userPass", userPass);

        user.setUserCard(userCard);
        user.setUserPass(userPass);

        String savedCode = (String) session.getAttribute("check_code");
        if (!userCheck.equals(savedCode)) {
            model.addAttribute("msg", "验证码错误，请重新输入！");
            return "index";
        }

        //再判断用户名是否匹配
        if (loginService.loginCheck(user)) {
            return "redirect:/chat/goToChat";
        } else {
            model.addAttribute("msg", "通行证与密码不匹配");
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session,HttpServletResponse response) {
        Cookie card = new Cookie("usercard", null);
        Cookie pwd = new Cookie("password", null);
        card.setMaxAge(60*60*24*3);
        pwd.setMaxAge(60*60*24*3);
        response.addCookie(card);
        response.addCookie(pwd);

        session.invalidate();
        return "redirect:/user/";
    }

    @RequestMapping("/goToUser")
    public String goToUser(HttpSession session, Model model) {
        User user = userService.findUser((String) session.getAttribute("userCard"));
        model.addAttribute("userName", user.getUserName() + "（EXP:" + user.getUserExp() + "）");
        model.addAttribute("msg", model.getAttribute("msg"));
        return "user";
    }

    @PostMapping("/changeName")
    public String changeUserName(@RequestParam("username") String userName,
                                 HttpSession session,
                                 Model model) {
        userService.changeUserName((String) session.getAttribute("userCard"), userName);
        model.addAttribute("msg", "修改成功");

        return "redirect:/user/goToUser";
    }

    @RequestMapping("/returnChatPage")
    public String returnChatPage() {
        return "redirect:/chat/goToChat";
    }

    @RequestMapping("/check")
    public void showCheckImage(HttpServletRequest request,
                               HttpServletResponse response
    ) throws IOException, ServletException {
        toolService.getImage(request, response);
    }
}
