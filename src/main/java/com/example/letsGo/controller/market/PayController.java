package com.example.letsGo.controller.market;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.market.Cart;
import com.example.letsGo.domain.market.Pay;
import com.example.letsGo.domain.market.Product;
import com.example.letsGo.repository.CartRepository;
import com.example.letsGo.repository.PayRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayRepository payRepository;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/confirm")
    public String getPayment(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }
        return "market/Pay";
    }

    @PostMapping("/confirm")
    public String confirmOrder(@RequestParam("name") String name,
                               @RequestParam("phone") String phone,
                               @RequestParam("zipcode") int zipcode,
                               @RequestParam("address") String address,
                               @RequestParam("address2") String address2,
                               @RequestParam("req") String req,
                               HttpSession session,
                               Model model,
                               RedirectAttributes redirectAttributes) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }

        // 주문 정보 저장
//        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
        List<Cart> cartList = cartRepository.findByUser(user);
        model.addAttribute("cartList", cartList);

        log.info(cartList.get(0).getProduct());
        for (Cart cart : cartList) {
            Product product = cart.getProduct();
            int totalPrice = product.getProductSellPrice() * cart.getAmount();

            Pay pay = Pay.builder()
                    .price(totalPrice)
                    .name(name)
                    .phone(phone)
                    .zipcode(zipcode)
                    .address(address)
                    .address2(address2)
                    .req(req)
                    .user(user)
                    .cart(cart)
                    .build();

            payRepository.save(pay);
        }

        session.removeAttribute("cartList");

        redirectAttributes.addFlashAttribute("message", "주문이 완료되었습니다.");
        return "redirect:/pay/complete";

    }

    @GetMapping("/payment")
    public String getAllOrders(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }

        // 해당 유저의 모든 주문 조회
        List<Pay> orderList = payRepository.findByUser(user);
        model.addAttribute("orderList", orderList);

        return "market/UserOrders";
    }

    @DeleteMapping("/pay/{orderId}")
    public String cancelOrder(@PathVariable Long orderId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }

       /* payRepository.deleteById(orderId);*/

        return "redirect:/pay/orders";
    }

    @GetMapping("/complete")
    public String orderComplete() {
        return "market/CompletePayment";
    }
    /*민주 추가 부분*/
    @GetMapping("/cancel/{orderId}")
    public String cancelOrder(@PathVariable Long orderId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }

        // 주문 취소 로직 수행 (여기서는 단순히 삭제)
        payRepository.deleteById(orderId);

        // 다시 주문 조회 페이지로 리다이렉트
        return "redirect:/orders";
    }
}
