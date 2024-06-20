package com.example.letsGo.controller.market;

import com.example.letsGo.domain.product.Product;
import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.product.ProductScrap;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.ProductScrapRepository;
import com.example.letsGo.repository.UserRepository;
import com.example.letsGo.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("user")
@RequestMapping("/market")
@Log4j2
public class ProductController {
    @Autowired
    private ProductScrapRepository productScrapRepository;

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/list")
    public String getAllProduct(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);

        return "market/Market";
    }

    // 물품 스크랩
    @PostMapping("/scrap")
    public String scrapProduct(@RequestParam("productId") Long productId,
                               HttpSession session,
                               RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        user = userRepository.findByUser_id(user.getUser_id());

        if (user == null) {
            return "redirect:/signin/signin";
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다: " + productId));

        ProductScrap existingScrap = productScrapRepository.findByUserAndProduct(user, product);
        if (existingScrap != null) {
            redirectAttributes.addFlashAttribute("message", "이미 스크랩한 상품입니다.");
            return "redirect:/market/list";
        }

        ProductScrap productScrap = ProductScrap.builder()
                .user(user)
                .product(product)
                .build();

        productScrapRepository.save(productScrap);
        redirectAttributes.addFlashAttribute("message", "상품을 스크랩하였습니다.");

        return "redirect:/market/list";
    }
}
