package com.example.letsGo.dao;


import com.example.letsGo.domain.product.Pay;

import java.util.List;

public interface PayDao {
    List<Pay> getAllOrders(); // 모든 주문 조회
    List<Pay> getOrdersByUserId(int userId); // 특정 사용자의 주문 조회
    Pay payProduct(int orderId); // 주문 추가
    Boolean cancelOrder(int orderId); // 주문 취소
}
