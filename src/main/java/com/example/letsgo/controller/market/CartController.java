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
    public String addToCart(@RequestBody int cartId) {
        marketService.addToCart(cartId);
        return "redirect:/cart";
    }

    @DeleteMapping("/{cartId}")
    public String removeFromCart(@PathVariable int cartId) {
        marketService.removeFromCart(cartId);
        return "redirect:/cart";
    }
}
