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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/market")
public class ProductController {
    private final MarketService marketService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(MarketService marketService) {
        this.marketService = marketService;
    }
    @PostConstruct
    public void init() {
        logger.info("ProductController initialized.");
    }
    @GetMapping
    public String getAllProduct(Model model) {
        List<Product> productList = marketService.getAllProducts();
        model.addAttribute("productList", productList);

        logger.info("Request to /market received. Number of products retrieved: {}", productList.size());

        return "market/Market";
    }
}
