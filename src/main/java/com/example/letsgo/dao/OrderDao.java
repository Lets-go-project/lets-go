package com.example.letsgo.dao;

import com.example.letsgo.domain.market.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrders(); // 모든 주문 조회
    List<Order> getOrdersByUserId(int userId); // 특정 사용자의 주문 조회
    Order addOrder(int orderId); // 주문 추가
    Boolean updateOrder(int orderId); // 주문 정보 업데이트 (주소지 변경 등...)
    Boolean cancelOrder(int orderId); // 주문 취소
}
