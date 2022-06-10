package com.shiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        //这里面填的是请求路径
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").
//                //所有路径全都拦截包括静态资源
//                excludePathPatterns("/login","/","/login/admin","static/**", "/image/**",
//                        "/static/css/**");
//    }
}
