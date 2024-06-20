package com.example.letsGo.controller.salesManager;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.product.Product;
import com.example.letsGo.domain.salesmanager.SalesManager;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.SalesManagerRepository;
import com.example.letsGo.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/market/manager")
public class SalesManagerController {
    @Autowired
    private SalesManagerRepository salesManagerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping("/")
    public String getSalesManagerPage(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            return "redirect:/signin/signin";
        }
        User user = userRepository.findById(sessionUser.getId());
        List<Product> registeredProductList = productRepository.findBySalesManager(user.getSalesManager());
        model.addAttribute("registeredProductList", registeredProductList);

        return "salesManager/SalesManager";
    }

    @GetMapping("/add")
    public String getProductForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        } else {
            model.addAttribute("user", user);
            return "salesManager/RegisterProductForm";
        }
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("productName") String productName,
                             @RequestParam("productType") int productType,
                             @RequestParam("productQuantity") int productQuantity,
                             @RequestParam("productPrice") int productPrice,
                             @RequestParam("productSellPrice") int productSellPrice,
                             @RequestParam("productDescription") String productDescription,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }

        try {
            // Product 객체 생성 및 저장
            Product product = Product.builder()
                    .productName(productName)
                    .productType(productType)
                    .productPrice(productPrice)
                    .productState("판매중")
                    .productQuantity(productQuantity)
                    .productSellPrice(productSellPrice)
                    .productDescription(productDescription)
                    .isAccept(0)
                    .productImg("https://ifh.cc/g/Tya3nl.jpg")
                    .build();

             if (user.getIsSalesManager() == 0) {
                user.setIsSalesManager(1);
                SalesManager salesManager = SalesManager.builder()
                        .name(user.getName())
                        .member(user)
                        .build();

                salesManagerRepository.save(salesManager);
            }
             product.setSalesManager(user.getSalesManager());

            productRepository.save(product);
            userRepository.save(user);

            redirectAttributes.addFlashAttribute("message", "상품 등록 성공");

            return "redirect:/market/manager/complete";
        } catch (Exception e) {
            log.error("상품 등록 실패: " + e.getMessage());
            redirectAttributes.addFlashAttribute("error", "상품 등록 실패");
            return "redirect:/market/manager"; // 실패 시 관리자 페이지로 리다이렉트
        }
    }

    @GetMapping("/complete")
    public String orderComplete() {
        return "salesManager/CompleteRegisterProduct";
    }

}