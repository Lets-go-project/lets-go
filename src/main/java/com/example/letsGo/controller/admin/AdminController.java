package com.example.letsGo.controller.admin;

import com.example.letsGo.domain.product.Product;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    public ProductRepository productRepository;

    @PostMapping("/signin/admin")
    public String signinAdmin(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpServletRequest request) {
        boolean isValidAdmin = adminService.validateAdmin(name, password);
        if (isValidAdmin) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", "admin");  // 관리자 세션 속성 설정
            return "redirect:/admin/list";  // 로그인 성공
        } else {
            model.addAttribute("error", "Invalid Name or password");
            return "signin/adminLogin";  // 로그인 실패
        }
    }

    //대기 중 상품 리스트 반환 -> html
    @GetMapping("/admin/list")
    public String getPendingProducts(Model model) {
        List<Product> pendingProductList = productRepository.findByIsAccept(0);  // 승인 대기중인 물품 불러오기
        model.addAttribute("pendingProductList", pendingProductList);
        return "market/AdminPage";
    }

    //상품 승인
    @PostMapping("/admin/approve")
    public String approveProducts(@RequestBody List<Long> productIds, Model model) {
        for (Long productId : productIds) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                product.setIsAccept(1);
                productRepository.save(product);
            }
        }
        return "redirect:/admin/list";
    }

    //상품 반려
    @PostMapping("/admin/reject")
    public String rejectProducts(@RequestBody List<Long> productIds) {
        for (Long productId : productIds) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                product.setIsAccept(2);
                productRepository.save(product);
            }
        }
        return "redirect:/admin/list";
    }
}