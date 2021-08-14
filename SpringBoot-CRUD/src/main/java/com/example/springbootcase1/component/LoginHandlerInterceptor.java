package com.example.springbootcase1.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 目标方法执行前
        Object user = request.getSession().getAttribute("loginUser");
        System.out.println("进入判断前");
        if(user == null){
            //未登陆，返回登陆页面
            request.setAttribute("msg","您的通行证不是管理员，无权进入后台");
            request.getRequestDispatcher("/index.html").forward(request,response);
            System.out.println("没有权限的访问，拦截");
            return false;
        }else{
            //已登陆，放行请求
            System.out.println("有权限的访问，放行");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
