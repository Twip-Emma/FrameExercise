package com.example.springbootcasechat.config;

import com.example.springbootcasechat.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/test2","/testPost","/user/check","/user/userTryLogin","/user/","/","/register/","/register/**");
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
    }
}
