package com.example.letsgo.dao.mybatis.mapper;

import com.example.letsgo.domain.market.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProducts(); // 모든 상품 조회
    Product getDetailProduct(int productId); // 상품 상세페이지 조회
    List<Product> searchProductByName(String productName); // 상품 검색
    List<Product> searchProductByProductType(int productType); // 상품 타입별 필터링
}
