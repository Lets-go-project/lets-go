package com.example.letsGo.service;

import com.example.letsGo.domain.market.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts(); // 모든 상품 조회
    Product getDetailProduct(int productId); // 상품 상세페이지 조회
    List<Product> searchProductByName(String productName); // 상품 검색
    List<Product> searchProductByType(int productType); // 상품 검색
    Boolean scrapProduct(int productId, int userId);
}
