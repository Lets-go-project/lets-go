package com.example.letsGo.dao.mybatis.mapper;

import com.example.letsGo.domain.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getAllProducts(); // 모든 상품 조회
    Product getDetailProduct(int productId); // 상품 상세페이지 조회
    List<Product> searchProductByName(String productName); // 상품 검색
    List<Product> searchProductByType(int productType); // 상품 검색
    Boolean scrapProduct(int productId, int userId); // 상품 스크랩

}
