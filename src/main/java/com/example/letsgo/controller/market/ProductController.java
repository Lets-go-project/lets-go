package com.example.letsgo.controller.market;

import com.example.letsgo.dao.ProductDao;
import com.example.letsgo.domain.market.Product;
import com.example.letsgo.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/market")
public class ProductController {
    private final MarketService marketService;

    @Autowired
    public ProductController(MarketService marketService) {
        this.marketService = marketService;
    }

     @GetMapping
    public String getAllProduct(Model model) {
        List<Product> productList = marketService.getAllProducts();
        model.addAttribute("productList", productList);
        return "market/Market";
    }
}
