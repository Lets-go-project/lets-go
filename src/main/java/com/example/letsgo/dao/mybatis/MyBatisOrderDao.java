package com.example.letsgo.dao.mybatis;

import com.example.letsgo.dao.CartDao;
import com.example.letsgo.dao.OrderDao;
import com.example.letsgo.dao.mybatis.mapper.CartMapper;
import com.example.letsgo.dao.mybatis.mapper.OrderMapper;
import com.example.letsgo.domain.market.Cart;
import com.example.letsgo.domain.market.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisOrderDao implements OrderDao {
    private final OrderMapper orderMapper;

    public MyBatisOrderDao(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    public List<Order> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderMapper.getOrdersByUserId(userId);
    }

    @Override
    public Order addOrder(int orderId) {
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