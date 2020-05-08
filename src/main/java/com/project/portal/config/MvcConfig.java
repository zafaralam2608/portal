package com.project.portal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/portal").setViewName("index");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/success").setViewName("success");
    }
}
