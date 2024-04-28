package com.example.letsgo.controller.market;

import com.example.letsgo.domain.market.Product;
import com.example.letsgo.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductDetailController {
    private MarketService marketService;

    @Autowired
    public ProductDetailController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/detail")
    public String getDetailProduct(@RequestParam("productId") int productId, Model model) {
        Product product = marketService.getDetailProduct(productId);
        model.addAttribute("product", product);
        return "/market/ProductDetailView"; // 상품 상세페이지를 보여줄 뷰의 경로
    }
}
