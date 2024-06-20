package com.example.letsGo.controller.myPage;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.product.Pay;
import com.example.letsGo.repository.PayRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private PayRepository payRepository;

    @GetMapping("/orders")
    public String getAllOrders(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }

        // 해당 유저의 모든 주문 조회
        List<Pay> orderList = payRepository.findByUser(user);
        model.addAttribute("orderList", orderList);

        return "mypage/order"; // templates/mypage/order.html 파일을 참조
    }
}
