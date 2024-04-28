package com.example.letsgo.dao;

import com.example.letsgo.domain.market.Cart;

import java.util.List;

public interface CartDao {
    List<Cart> getAllCarts();   // 장바구니 조회
    Cart addToCart(Cart cart);  // 장바구니에 상품 추가
    Boolean removeFromCart(int cartId); // 장바구니 전체/선택 삭제
}
