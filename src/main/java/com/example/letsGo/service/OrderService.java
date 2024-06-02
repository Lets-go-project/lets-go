package com.example.letsGo.service;

import com.example.letsGo.domain.market.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders(); // 모든 주문 조회
    Order addOrder(int orderId); // 주문 추가
    Boolean updateOrder(int orderId); // 주문 정보 업데이트 (주소지 변경 등...)
    Boolean cancelOrder(int orderId); // 주문 취소
}
