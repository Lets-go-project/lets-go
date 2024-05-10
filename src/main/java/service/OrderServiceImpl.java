package service;

import dao.OrderDao;
import domain.market.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public Order addOrder(int orderId) {
        return orderDao.addOrder(orderId);
    }

    public Boolean updateOrder(int orderId) {
        return orderDao.updateOrder(orderId);
    }

    public Boolean cancelOrder(int orderId) {
        return orderDao.cancelOrder(orderId);
    }
}
