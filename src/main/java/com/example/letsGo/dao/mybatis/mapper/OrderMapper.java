package com.example.letsGo.dao.mybatis.mapper;

import com.example.letsGo.domain.product.Pay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Pay> getAllOrders(); // 모든 주문 조회
    List<Pay> getOrdersByUserId(int userId); // 특정 사용자의 주문 조회
    Pay addOrder(int orderId); // 주문 추가
    Boolean cancelOrder(int orderId); // 주문 취소
}
