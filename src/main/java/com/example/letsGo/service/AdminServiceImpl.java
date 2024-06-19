package com.example.letsGo.service;

import com.example.letsGo.domain.market.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Override
    public void acceptProduct(int productId) {

    }

    @Override
    public void rejectProduct(int productId) {

    }

    @Override
    public List<Product> getPendingProducts() {
        return null;
    }
}
