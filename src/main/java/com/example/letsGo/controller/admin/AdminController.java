package com.example.letsGo.controller.admin;


import com.example.letsGo.domain.market.Product;
import com.example.letsGo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/pendingProducts")
    public String getPendingProducts(Model model) {
        List<Product> pendingProducts = adminService.getPendingProducts();
        model.addAttribute("pendingProducts", pendingProducts);
        return "/admin/pendingProducts";
    }

    @PostMapping("/accept/{productId}")
    public String acceptProduct(@PathVariable int productId) {
        adminService.acceptProduct(productId);
        return "redirect:/admin/pendingProducts";
    }

    @PostMapping("/rejectProduct/{productId}")
    public String rejectProduct(@PathVariable int productId) {
        adminService.rejectProduct(productId);
        return "redirect:/admin/pendingProducts";
    }
}