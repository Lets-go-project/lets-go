package com.example.letsGo.controller.market;

import com.example.letsGo.domain.market.Cart;
import com.example.letsGo.domain.market.Product;
import com.example.letsGo.domain.member.User;
import com.example.letsGo.repository.CartRepository;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.UserRepository;
import com.example.letsGo.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
@Log4j2
public class CartController {
    private final ProductService productService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllCarts(Model model) {
        List<Cart> cartList = productService.getAllCarts();
        model.addAttribute("cartList", cartList);
        return "/market/Cart";
    }

    @PostMapping("/add")
    public String addToCart(
            @RequestParam("productId") Long productId,
            @RequestParam(value = "amount", required = false, defaultValue = "1") int amount,
            HttpSession session)
    {
        User sessionUser = (User) session.getAttribute("user");
        User user = userRepository.findByUserId(sessionUser.getUserId());

        log.info(sessionUser.getUserId());

        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            throw new RuntimeException("제품을 찾을 수 없습니다");
        }

        System.out.println("사용자 ID: " + user.getUserId());
        System.out.println("제품 ID: " + productId);
        System.out.println("제품 이름: " + product.getProductName());

        Cart cart = Cart.builder()
                .product(product)
                .amount(amount)
                .userId(user.getUserId())
                .build();

        cartRepository.save(cart);

        return "market/Cart"; // 장바구니 페이지로 리다이렉트
    }


    @DeleteMapping("/{cartId}")
    public String removeFromCart(@PathVariable int cartId) {
        productService.removeFromCart(cartId);
        return "redirect:/cart";
    }
}
