package com.example.letsGo.controller.myPage;

import com.example.letsGo.domain.market.ProductScrap;
import com.example.letsGo.domain.member.User;
import com.example.letsGo.service.ProductsScrapService;
import com.example.letsGo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ScrapController {

    @Autowired
    private ProductsScrapService productsScrapService;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserService userService;

    @GetMapping("/scraps")
    public String getUserScraps(Model model, @RequestParam("user_id") int userId) {
        User user = userService.getUserByUserId(userId);
        if (user == null) {
            return "error";
        }

        List<ProductScrap> scraps = productsScrapService.getProductScrapsByUser(userId);
        model.addAttribute("user", user);
        model.addAttribute("scraps", scraps);

        return "mypage/postscrap";
    }
}
