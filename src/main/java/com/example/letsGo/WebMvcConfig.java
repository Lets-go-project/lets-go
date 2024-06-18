package com.example.letsGo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:/C:/uploads/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/letsGo").setViewName("index");

        /*
        규민: 마켓 & 판매 관리자
        */
        registry.addViewController("/market/list").setViewName("market/Market");
        registry.addViewController("/market/searchByName").setViewName("market/Market");
        registry.addViewController("/market/searchByType").setViewName("market/Market");
        registry.addViewController("/market/detail").setViewName("market/ProductDetailView");
        registry.addViewController("/market/cart").setViewName("market/Cart");
        registry.addViewController("/cart/view").setViewName("market/Cart");
        registry.addViewController("/cart/add").setViewName("market/Cart");
        registry.addViewController("/cart/remove/{cartId}").setViewName("market/Cart");
        registry.addViewController("/market/order").setViewName("market/Pay");

        registry.addViewController("/market/manager").setViewName("salesManager/SalesManager");
        registry.addViewController("/market/manager/add").setViewName("salesManager/SalesManager");

        /*
        진희: 기록 & 챌린지
        */
        registry.addViewController("/record/view").setViewName("/record/viewRecord");
        registry.addViewController("/record/add").setViewName("/record/addRecord");
        registry.addViewController("/record/update").setViewName("/record/updateRecord");
        registry.addViewController("/record/delete").setViewName("/record/updateRecord");

        registry.addViewController("/challenge/all").setViewName("/challenge/challenge");
        registry.addViewController("/challenge/woman").setViewName("/challenge/challenge");
        registry.addViewController("/challenge/man").setViewName("/challenge/challenge");
        registry.addViewController("/challenge/filtering").setViewName("/challenge/challenge");

        /*
        예슬: 수영장 정보 & 관리자
        */
        registry.addViewController("/swimpool/search").setViewName("/swimpool/Search");

        /*
        민주: 로그인 & 회원가입 & 마이페이지
        */
        registry.addViewController("/mypage/mypage").setViewName("/mypage/mypage");
        registry.addViewController("/mypage/memberinfo").setViewName("/mypage/memberinfo");
        registry.addViewController("/mypage/poolscrap").setViewName("/mypage/poolscrap");
        registry.addViewController("/mypage/postscrap").setViewName("/mypage/postscrap");

        registry.addViewController("/signin/signin").setViewName("/signin/signin");
        registry.addViewController("/signup/signup").setViewName("/signup/signup");
    }
}

