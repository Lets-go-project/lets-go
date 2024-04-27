package com.example.letsgo.dao;

import com.example.letsgo.domain.Market.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts(); // 모든 상품 조회
    Product getProductByName(int productName); // 상품 검색
    List<Product> getProductsBySalesManagerId(int salesManagerId);
    void addProduct(Product product); // 상품 등록
    void updateProduct(Product product); // 상품 정보 업데이트
    void deleteProduct(int productId); // 상품 삭제
}
