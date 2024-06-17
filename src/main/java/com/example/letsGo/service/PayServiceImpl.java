package com.example.letsGo.service;

import com.example.letsGo.dao.PayDao;
import com.example.letsGo.domain.market.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayDao payDao;

    public List<Pay> getAllOrders() {
        return payDao.getAllOrders();
    }

    public Pay addOrder(int orderId) {
        return payDao.addOrder(orderId);
    }

    public Boolean updateOrder(int orderId) {
        return payDao.updateOrder(orderId);
    }

    public Boolean cancelOrder(int orderId) {
        return payDao.cancelOrder(orderId);
    }
}
