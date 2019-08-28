package com.memory.study.config;

import com.memory.study.interceptor.AuthInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * created by memory
 * on 2019/8/28 10 52
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(WebAppConfig.class);
    @Autowired
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("执行addInterceptors");
        registry.addInterceptor(authInterceptor).addPathPatterns("/hello/*");
    }
}
