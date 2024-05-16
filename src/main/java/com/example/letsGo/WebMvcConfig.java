package com.example.letsGo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/letsGo").setViewName("index");

        registry.addViewController("/market/list").setViewName("/market/Market");
        registry.addViewController("/market/detail").setViewName("/market/ProductDetailView");

        registry.addViewController("/record/view").setViewName("record/viewRecord");
        registry.addViewController("/record/add").setViewName("record/addRecord");
        registry.addViewController("/record/update").setViewName("record/updateRecord");
        registry.addViewController("/record/delete").setViewName("record/updateRecord");

        registry.addViewController("/challenge/all").setViewName("challenge/challenge");
        registry.addViewController("/challenge/woman").setViewName("challenge/challenge");
        registry.addViewController("/challenge/man").setViewName("challenge/challenge");
        registry.addViewController("/challenge/filtering").setViewName("challenge/challenge");
    }
}

