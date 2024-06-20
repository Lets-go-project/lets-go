package com.example.letsGo.controller.market;

import com.example.letsGo.domain.product.Cart;
import com.example.letsGo.domain.product.Product;
import com.example.letsGo.domain.member.User;
import com.example.letsGo.repository.CartRepository;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
//            model.addAttribute("loginRequired", true);
            return "redirect:/signin/signin";
        }

        User user = userRepository.findById(sessionUser.getUser_id())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다"));
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
            HttpSession session,
            Model model) {
        User sessionUser = (User) session.getAttribute("user");
        User user = userRepository.findById(sessionUser.getId());
        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            throw new RuntimeException("제품을 찾을 수 없습니다");
        }

        List<Cart> cartList = cartRepository.findByUser(user);

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

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

        // 총 합계 계산
        int totalProductPrice = 0;
        if (!cartList.isEmpty()) {
            totalProductPrice = cartList.stream()
                    .mapToInt(cartItem -> (int) (cartItem.getProduct().getProductPrice() * cartItem.getAmount()))
                    .sum();
        }
        log.info("totalProductPrice: " + totalProductPrice);

        model.addAttribute("totalProductPrice", totalProductPrice);
        model.addAttribute("cartList", cartList);

        Cart cart = Cart.builder()
                .product(product)
                .amount(amount)
                .user(user)
                .build();

        cartRepository.save(cart);

        return "redirect:/cart/list";
    }

    //    @DeleteMapping("/remove/{cartId}")
    @PostMapping("/remove/{cartId}")
    public String removeFromCart(@PathVariable Long cartId) {
        cartRepository.deleteById(cartId);
        return "redirect:/cart/list";
    }

    @PostMapping("/update")
    public String updateCart(
            @RequestParam("cartId") Long cartId,
            @RequestParam("amount") int newAmount,
            Model model) {
        Cart cartItem = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("장바구니 항목을 찾을 수 없습니다"));

        Cart.builder().amount(newAmount).build();
        cartRepository.save(cartItem);

        return "redirect:/cart/list";
    }
}

