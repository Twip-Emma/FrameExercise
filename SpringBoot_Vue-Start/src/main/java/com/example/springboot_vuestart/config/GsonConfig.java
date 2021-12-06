package com.example.springboot_vuestart.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

@Configuration
public class GsonConfig {

    //自定义转换器
    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter(){
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy--MM--dd");
        gsonBuilder.excludeFieldsWithModifiers(Modifier.PROTECTED);//设置忽略字段
        Gson gson = gsonBuilder.create();
        gsonHttpMessageConverter.setGson(gson);
        return gsonHttpMessageConverter;
    }
}
