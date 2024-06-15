package com.example.letsGo.repository;

import com.example.letsGo.domain.market.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByName(String name);
    Order findByOrderId(Long orderId);
}
