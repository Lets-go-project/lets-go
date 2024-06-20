package com.example.letsGo.controller.admin;

import com.example.letsGo.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signin/admin")
    public String signinAdmin(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpServletRequest request) {
        boolean isValidAdmin = adminService.validateAdmin(name, password);
        if (isValidAdmin) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", "admin");  // 관리자 세션 속성 설정
            return "redirect:/adminPage";  // 로그인 성공 시 리다이렉트할 경로
        } else {
            model.addAttribute("error", "Invalid Name or password");
            return "signin/adminLogin";  // 로그인 실패 시 리턴할 템플릿 경로
        }
    }
}