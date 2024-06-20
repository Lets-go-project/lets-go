package com.example.letsGo.service;

import com.example.letsGo.domain.product.Cart;
import com.example.letsGo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addToCart(int cartId) {
        return null;
    }

    @Override
    public Boolean removeFromCart(int cartId) {
        return null;
    }
}
