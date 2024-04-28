package com.example.letsgo.dao;

import com.example.letsgo.domain.market.Product;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts(); // 모든 상품 조회
    List<Product> searchProductByName(String productName); // 상품 검색
    List<Product> searchProductByProductType(int productType); // 상품 타입별 필터링
}
