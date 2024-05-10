package dao.mybatis;

import dao.CartDao;
import dao.OrderDao;
import dao.mybatis.mapper.CartMapper;
import dao.mybatis.mapper.OrderMapper;
import domain.market.Cart;
import domain.market.Order;
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