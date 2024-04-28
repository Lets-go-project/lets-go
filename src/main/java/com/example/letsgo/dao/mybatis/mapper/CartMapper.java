package com.example.letsgo.dao.mybatis.mapper;

import com.example.letsgo.domain.market.Cart;
import com.example.letsgo.domain.market.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<Cart> getAllCarts();   // 장바구니 조회
    Cart addToCart(int cartId);  // 장바구니에 상품 추가
    Boolean removeFromCart(int cartId); // 장바구니 전체/선택 삭제
}
