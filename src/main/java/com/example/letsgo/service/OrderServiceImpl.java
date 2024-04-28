package com.example.letsgo.service;

import com.example.letsgo.dao.OrderDao;
import com.example.letsgo.domain.market.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderService orderService;

    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    public Order addOrder(int orderId) {
        return orderService.addOrder(orderId);
    }

    public Boolean updateOrder(Order order) {
        return orderService.updateOrder(order);
    }

    public Boolean cancelOrder(int orderId) {
        return orderService.cancelOrder(orderId);
    }
}
