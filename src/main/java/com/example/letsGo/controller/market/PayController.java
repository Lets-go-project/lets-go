package com.example.letsGo.controller.market;

import com.example.letsGo.repository.PayRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pay")
public class PayController {
    private PayRepository payRepository;

    @GetMapping
    public String getAllOrders(Model model) {
//        List<Pay> payList = payService.getAllOrders();
//        model.addAttribute("orderList", payList);
        return "/market/Order";
    }

/*
    @GetMapping("/{userId}")
    public String getOrdersByUserId(@PathVariable int userId, Model model) {
        List<Order> orderList = orderService.getOrdersByUserId(userId);
        model.addAttribute("orderList", orderList);
        return "market/UserOrders"; // 특정 사용자의 주문을 보여줄 뷰의 경로
    }
*/

    @PostMapping
    public String addOrder(@RequestBody int orderId) {
//        payService.addOrder(orderId);
        return "redirect:/orders";
    }

    @PutMapping("/{oId}")
    public String updateOrder(@PathVariable int oId, @RequestBody int orderId) {
//        order.setOrderId(orderId);
//        payService.updateOrder(orderId);
        return "redirect:/orders";
    }

    @DeleteMapping("/{orderId}")
    public String cancelOrder(@PathVariable int orderId) {
//        payService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
