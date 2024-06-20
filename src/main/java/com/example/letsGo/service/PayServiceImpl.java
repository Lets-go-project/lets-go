package com.example.letsGo.service;

import com.example.letsGo.domain.market.Pay;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Override
    public List<Pay> getAllOrders() {
        return null;
    }

    @Override
    public Pay payProduct(Long orderId) {
        return null;
    }

    @Override
    public Boolean cancelOrder(Long orderId) {
        return null;
    }
}
