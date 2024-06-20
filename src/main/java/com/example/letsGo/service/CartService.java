package com.example.letsGo.service;

import com.example.letsGo.domain.product.Cart;
import com.example.letsGo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();   // 장바구니 조회
    Cart addToCart(int cartId);  // 장바구니에 상품 추가
    Boolean removeFromCart(int cartId); // 장바구니 전체/선택 삭제

}
