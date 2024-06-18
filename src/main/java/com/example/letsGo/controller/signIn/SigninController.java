package com.example.letsGo.controller.signIn;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@Log4j2
public class SigninController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public String signin(@RequestParam("id") String id, @RequestParam("password") String password, Model model, HttpServletRequest request) {
        User user = userService.getUserById(id);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            return "redirect:/letsGo";  // 로그인 성공 시 리다이렉트할 경로
        } else {
            model.addAttribute("error", "Invalid ID or password");
            return "signin/signin";  // 로그인 실패 시 리턴할 템플릿 경로
        }
    }
}