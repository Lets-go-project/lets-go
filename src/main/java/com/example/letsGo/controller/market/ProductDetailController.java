package com.example.letsGo.controller.market;

import com.example.letsGo.domain.market.Product;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.service.MarketService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/market")
@Log4j2
public class ProductDetailController {
    private final MarketService marketService;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public ProductDetailController(MarketService marketService) {
        this.marketService = marketService;
    }
    @PostConstruct
    public void init() {
        log.info("productDetailController: 호출 성공~");
    }
    @GetMapping("/detail")
    public String getDetailProduct(
            @RequestParam("productId") Long productId,
            @RequestParam("productType") int productType,
            Model model
    ) {
        Product product = productRepository.findByProductId(productId);
        List<Product> relatedProductList =  productRepository.findByProductType(productType).stream()
            .filter(p -> !p.getProductId().equals(productId))
            .collect(Collectors.toList());

        model.addAttribute("product", product);
        model.addAttribute("relatedProductList", relatedProductList);

        log.info("productDetailController: "+productId);

        return "market/ProductDetailView";
    }
}
