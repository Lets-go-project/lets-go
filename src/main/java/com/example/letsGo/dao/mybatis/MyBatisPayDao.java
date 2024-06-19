package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.PayDao;
import com.example.letsGo.dao.mybatis.mapper.OrderMapper;
import com.example.letsGo.domain.product.Pay;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisPayDao implements PayDao {
    private final OrderMapper orderMapper;

    public MyBatisPayDao(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    public List<Pay> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    @Override
    public List<Pay> getOrdersByUserId(int userId) {
        return orderMapper.getOrdersByUserId(userId);
    }

    @Override
    public Pay addOrder(int orderId) {
        return orderMapper.addOrder(orderId);
    }

    @Override
    public Boolean updateOrder(int orderId) {
        return orderMapper.updateOrder(orderId);
    }

    @Override
    public Boolean cancelOrder(int orderId) {
        return orderMapper.cancelOrder(orderId);
    }
}