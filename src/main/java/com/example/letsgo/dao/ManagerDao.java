package com.example.letsgo.dao;

import com.example.letsgo.domain.market.Product;
import org.springframework.stereotype.Component;

public interface ManagerDao {
    Product addProduct(Product product); // 상품 등록
    Boolean updateProduct(Product product); // 상품 정보 업데이트
    Boolean deleteProduct(int productId); // 상품 삭제
}
