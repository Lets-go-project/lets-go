package com.example.letsGo.controller.market;

import com.example.letsGo.domain.market.Product;
import com.example.letsGo.service.MarketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/market")
public class ProductDetailController {
    private final MarketService marketService;

    @Autowired
    public ProductDetailController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping("/detail")
    public String getDetailProduct(@RequestParam("productId") int productId, Model model) {
        Product product = marketService.getDetailProduct(productId);
        model.addAttribute("product", product);

        return "market/ProductDetailView";
    }
}
