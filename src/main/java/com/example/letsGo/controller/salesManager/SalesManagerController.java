package com.example.letsGo.controller.salesManager;

import com.example.letsGo.service.SalesManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market")
public class SalesManagerController {

    private final SalesManagerService salesManagerService;

    @Autowired
    public SalesManagerController(SalesManagerService salesManagerService) {
        this.salesManagerService = salesManagerService;
    }

    @GetMapping("/manager")
    public String getSalesManagerPage(Model model) {
//        List<Product> productList = salesManagerService.getAllProducts();
//        model.addAttribute("productList", productList);

        return "salesManager/SalesManager";
    }
}