package com.example.letsGo.controller.signIn;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*@Controller
public class SigninController {

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String getSignin() {
        return "signin/signin";
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String id, @RequestParam String password, Model model) {
        User user = userService.getUserById(id);
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/letsGo";
        } else {
            model.addAttribute("error", "Invalid ID or password");
            return "signin/signin";
        }
    }
}*/
@Controller
public class SigninController {

    @Autowired
    private UserService userService;

    @PostMapping("/signin")
    public String signin(@RequestParam("id") String id, @RequestParam("password") String password, Model model) {
        User user = userService.getUserById(id);
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/letsGo";  // 로그인 성공 시 리다이렉트할 경로
        } else {
            model.addAttribute("error", "Invalid ID or password");
            return "signin/signin";  // 로그인 실패 시 리턴할 템플릿 경로
        }
    }
}

