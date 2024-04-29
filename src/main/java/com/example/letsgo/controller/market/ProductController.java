package com.example.letsgo.controller.market;

import com.example.letsgo.domain.market.Product;
import com.example.letsgo.domain.member.User;
import com.example.letsgo.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

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

    // 상품 전체 조회
    @GetMapping
    public String getAllProduct(Model model) {
        List<Product> productList = marketService.getAllProducts();
        model.addAttribute("productList", productList);

        logger.info("Request to /market received. Number of products retrieved: {}", productList.size());

        return "market/Market";
    }

    // 물품 스크랩
    @PostMapping("/scrap")
    public String scrapProduct(@RequestParam("productId") int productId, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");

        if (currentUser == null) {
            return "redirect:/login";
        }

        marketService.scrapProduct(productId, currentUser.getUserId());

        return "redirect:/market";
    }
}
