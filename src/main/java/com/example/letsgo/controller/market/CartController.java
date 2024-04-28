package com.example.letsgo.controller.market;

import com.example.letsgo.domain.market.Cart;
import com.example.letsgo.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private MarketService marketService;
    @Autowired
    public CartController(MarketService marketService) {
        this.marketService = marketService;
    }
    @GetMapping
    public String getAllCarts(Model model) {
        List<Cart> cartList = marketService.getAllCarts();
        model.addAttribute("cartList", cartList);
        return "/market/Cart";
    }

    @PostMapping
    public String addToCart(@RequestBody Cart cart) {
        marketService.addToCart(cart);
        return "redirect:/cart"; // 상품을 장바구니에 추가한 후 모든 장바구니 정보를 보여주는 페이지로 리다이렉트
    }

    @DeleteMapping("/{cartId}")
    public String removeFromCart(@PathVariable int cartId) {
        marketService.removeFromCart(cartId);
        return "redirect:/cart"; // 장바구니에서 상품을 삭제한 후 모든 장바구니 정보를 보여주는 페이지로 리다이렉트
    }
}
