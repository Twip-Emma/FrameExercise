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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @Autowired
    ToolService toolService;

    @Autowired
    User user;

    @RequestMapping("/")
    public String hello(){
        return "index";
    }

    @PostMapping("/userTryLogin")
    public String userLogin(@RequestParam("card")String userCard,
                            @RequestParam("password")String userPass,
                            @RequestParam("check")String userCheck,
                            HttpSession session, Model model){
        session.setAttribute("userCard",userCard);
        session.setAttribute("userPass",userPass);

        user.setUserCard(userCard);
        user.setUserPass(userPass);

        String savedCode =(String) session.getAttribute("check_code");
        if(!userCheck.equals(savedCode)){
            model.addAttribute("msg","验证码错误，请重新输入！");
            return "index";
        }

        //再判断用户名是否匹配
        if(loginService.loginCheck(user)){
            return "redirect:/chat/goToChat";
        }else{
            model.addAttribute("msg","通行证与密码不匹配");
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/user/index";
    }

    @RequestMapping("/goToUser")
    public String goToUser(HttpSession session,Model model){
        String userName = userService.findUserName((String) session.getAttribute("userCard"));
        model.addAttribute("userName",userName);
        model.addAttribute("msg", model.getAttribute("msg"));
        return "user";
    }

    @PostMapping("/changeName")
    public String changeUserName(@RequestParam("username")String userName,
                                 HttpSession session,
                                 Model model){
        userService.changeUserName((String) session.getAttribute("userCard"),userName);
        model.addAttribute("msg","修改成功");
        return "redirect:/user/goToUser";
    }

    @RequestMapping("/returnChatPage")
    public String returnChatPage(){
        return "redirect:/chat/goToChat";
    }

    @RequestMapping("/check")
    public void showCheckImage(HttpServletRequest request,
                                 HttpServletResponse response
                                 )throws IOException, ServletException {
        toolService.getImage(request, response);
    }
}
