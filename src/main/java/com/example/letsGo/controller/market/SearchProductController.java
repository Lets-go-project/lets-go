package com.example.letsGo.controller.market;

import com.example.letsGo.domain.market.Product;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/market")
public class SearchProductController {
    private final ProductService productService;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public SearchProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/searchByName")
    public String searchProductByName(@RequestParam("keyword") String productName, Model model) {
        List<Product> searchProductList = productRepository.findByProductName(productName);
        model.addAttribute("productList", searchProductList);
        return "market/Market";
    }

    @GetMapping("/searchByType")
    public String searchProductByType(@RequestParam("productType") int productType, Model model) {
        List<Product> searchProductList;
        if (productType == 0) {
            searchProductList = productRepository.findAll();
        } else {
            searchProductList = productRepository.findByProductType(productType);
        }
        model.addAttribute("productList", searchProductList);
        model.addAttribute("selectedProductType", productType);
        return "market/Market";
    }
}
