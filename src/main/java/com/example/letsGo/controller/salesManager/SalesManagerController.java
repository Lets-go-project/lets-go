package com.example.letsGo.controller.salesManager;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.service.SalesManagerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market/manager")
public class SalesManagerController {

    private final SalesManagerService salesManagerService;

    @Autowired
    public SalesManagerController(SalesManagerService salesManagerService) {
        this.salesManagerService = salesManagerService;
    }

    @GetMapping("/")
    public String getSalesManagerPage(Model model) {
//        List<Product> productList = salesManagerService.getAllProducts();
//        model.addAttribute("productList", productList);

        return "salesManager/SalesManager";
    }

    @GetMapping("/add")
    public String getProductForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
         if (user != null) {
             model.addAttribute("user", user);
         }
//        List<Product> productList = salesManagerService.getAllProducts();
//        model.addAttribute("productList", productList);

        return "salesManager/RegisterProductForm";
    }
    @PostMapping("/add")
    public String registerProduct() {
//        List<Product> productList = salesManagerService.getAllProducts();
//        model.addAttribute("productList", productList);

        return "salesManager/SalesManager";
    }
}