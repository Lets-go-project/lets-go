package com.example.letsGo.service;

import com.example.letsGo.domain.market.Cart;
import com.example.letsGo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void save(Cart cart) {
        cartRepository.save(cart);
    }
}
