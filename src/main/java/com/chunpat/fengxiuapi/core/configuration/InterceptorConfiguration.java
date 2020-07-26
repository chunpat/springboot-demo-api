package com.chunpat.fengxiuapi.core.configuration;

import com.chunpat.fengxiuapi.core.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptorAdapter handlerInterceptorAdapter(){
        return new PermissionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.handlerInterceptorAdapter());
    }
}
