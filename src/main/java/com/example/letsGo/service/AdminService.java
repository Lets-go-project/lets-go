package com.example.letsGo.service;

import com.example.letsGo.domain.market.Product;

import java.util.List;

public interface AdminService {
    void acceptProduct(int productId);
    void rejectProduct(int productId);
    List<Product> getPendingProducts();

}