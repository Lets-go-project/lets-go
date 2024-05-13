package com.example.letsGo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/market").setViewName("index");
        registry.addViewController("/market/list").setViewName("/market/Market");
        registry.addViewController("/market/detail").setViewName("/market/ProductDetailView");
    }
}

