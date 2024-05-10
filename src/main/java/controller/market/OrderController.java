package controller.market;

import domain.market.Order;
import service.MarketService;
import service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> orderList = orderService.getAllOrders();
        model.addAttribute("orderList", orderList);
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
        orderService.addOrder(orderId);
        return "redirect:/orders";
    }

    @PutMapping("/{oId}")
    public String updateOrder(@PathVariable int oId, @RequestBody int orderId) {
//        order.setOrderId(orderId);
        orderService.updateOrder(orderId);
        return "redirect:/orders";
    }

    @DeleteMapping("/{orderId}")
    public String cancelOrder(@PathVariable int orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
