package com.example.letsGo.controller.market;

import com.example.letsGo.domain.market.Product;
import com.example.letsGo.domain.member.User;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.service.MarketService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/market")
@Log4j2
public class ProductController {
    private final MarketService marketService;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public ProductController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostConstruct
    public void init() {
        log.info("ProductController initialized.");
        log.info("ProductController: 호출 성공~");
    }

    @GetMapping("/list")
    public String getAllProduct(Model model) {
          List<Product> productList = productRepository.findAll();
          model.addAttribute("productList", productList);

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
