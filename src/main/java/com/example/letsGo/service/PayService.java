package com.example.letsGo.service;

import com.example.letsGo.domain.product.Pay;

import java.util.List;

public interface PayService {
    List<Pay> getAllOrders(); // 모든 주문 조회
    Pay payProduct(int orderId); // 주문 추가
    Boolean cancelOrder(int orderId); // 주문 취소
}
