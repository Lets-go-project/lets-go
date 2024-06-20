package com.example.letsGo.controller.myPage;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.product.ProductScrap;
import com.example.letsGo.service.ProductsScrapService;
import com.example.letsGo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ScrapController {

    @Autowired
    private ProductsScrapService productsScrapService;

    @Autowired
    private UserService userService;

    @GetMapping("/scraps")
    public String getUserScraps(Model model, @RequestParam("user_id") int userId) {
        User user = userService.getUserByUserId(userId);
        if (user == null) {
            // 사용자가 없는 경우 에러 페이지로 리다이렉트 또는 에러 처리
            return "error";
        }

        List<ProductScrap> scraps = productsScrapService.getProductScrapsByUser(user.getUser_id());
        model.addAttribute("user", user);
        model.addAttribute("scraps", scraps);

        // Thymeleaf 템플릿 postscrap.html로 포워딩
        return "postscrap";
    }
}
