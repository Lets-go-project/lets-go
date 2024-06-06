package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.CartDao;
import com.example.letsGo.dao.mybatis.mapper.CartMapper;
import com.example.letsGo.domain.market.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisCartDao implements CartDao {
    private final CartMapper cartMapper;

    public MyBatisCartDao(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartMapper.getAllCarts();
    }

    @Override
    public Cart addToCart(int cartId) {
        return cartMapper.addToCart(cartId);
    }

    @Override
    public Boolean removeFromCart(int cartId) {
        return null;
    }
}