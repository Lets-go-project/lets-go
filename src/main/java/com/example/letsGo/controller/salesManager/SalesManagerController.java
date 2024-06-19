package com.example.letsGo.controller.salesManager;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.product.Product;
import com.example.letsGo.domain.salesmanager.SalesManager;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.SalesManagerRepository;
import com.example.letsGo.service.SalesManagerService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/market/manager")
public class SalesManagerController {
    @Autowired
    private SalesManagerRepository salesManagerRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String getSalesManagerPage(Model model) {
        return "salesManager/SalesManager";
    }

    @GetMapping("/add")
    public String getProductForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
         if (user != null) {
             model.addAttribute("user", user);
         }

        return "salesManager/RegisterProductForm";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("productName") String productName,
                             @RequestParam("productPrice") int productPrice,
                             @RequestParam("productSellPrice") int productSellPrice,
                             @RequestParam("productDescription") String productDescription,
//                             @RequestParam("useremail") String userEmail,
                             @RequestParam("files") MultipartFile[] files,
                             HttpSession session, Model model)
    {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        if (user == null) {
            return "redirect:/signin/signin";
        }

        try {
            Product product = Product.builder()
                            .productName(productName)
                            .productPrice(productPrice)
                            .productSellPrice(productSellPrice)
                            .productDescription(productDescription)
                            .productImg(Arrays.toString(files))
                            .build();

            productRepository.save(product);
            log.info(product.getProductImg()+"그리구 "+product.getProductDescription());

            return "redirect:/market/manager";
        } catch (Exception e) {
            model.addAttribute("f", "f");
            return "salesManager/RegisterProductForm";
        }
    }
}