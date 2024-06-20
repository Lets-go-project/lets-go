package com.example.letsGo.controller.market;

import com.example.letsGo.domain.market.Cart;
import com.example.letsGo.domain.market.Product;
import com.example.letsGo.domain.member.User;
import com.example.letsGo.repository.CartRepository;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
@Log4j2
public class CartController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/list")
    public String getCartList(Model model, HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        if (sessionUser == null) {
            return "redirect:/signin/signin";
        }

        User user = userRepository.findById(sessionUser.getId());
        List<Cart> cartList = cartRepository.findByUser(user);
        int totalProductPrice = 0;
        if (!cartList.isEmpty()) {
            totalProductPrice = cartList.stream()
                    .mapToInt(cartItem -> (int) (cartItem.getProduct().getProductSellPrice() * cartItem.getAmount()))
                    .sum();
        }
        model.addAttribute("cartList", cartList);
        model.addAttribute("totalProductPrice", totalProductPrice);
        return "market/Cart";
    }

    @PostMapping("/add")
    public String addToCart(
            @RequestParam("productId") Long productId,
            @RequestParam(value = "amount", required = false, defaultValue = "1") int amount,
            HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        User user = userRepository.findById(sessionUser.getId());

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다"));

        List<Cart> cartList = cartRepository.findByUser(user);

        // 장바구니에 같은 product가 있는지 확인
        Optional<Cart> existingCartItem = cartList.stream()
                .filter(cartItem -> cartItem.getProduct().getProductId().equals(productId))
                .findFirst();

         if (existingCartItem.isPresent()) {
            Cart cartItem = existingCartItem.get();
            Cart.builder().amount(cartItem.getAmount() + 1).build();

            cartRepository.save(cartItem);
        } else {
            Cart newCartItem = Cart.builder()
                    .product(product)
                    .amount(amount)
                    .user(user)
                    .build();
            cartRepository.save(newCartItem);
        }

        return "redirect:/cart/list";
    }

    @PostMapping("/remove/{cartId}")
    public String removeFromCart(@PathVariable Long cartId) {
        cartRepository.deleteById(cartId);
        return "redirect:/cart/list";
    }

    @PostMapping("/update")
    public String updateCart(
            @RequestParam("cartId") Long cartId,
            @RequestParam("amount") int newAmount) {
        Cart cartItem = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("장바구니 항목을 찾을 수 없습니다"));

        Cart.builder().amount(newAmount).build();
        cartRepository.save(cartItem);

        return "redirect:/cart/list";
    }
}
