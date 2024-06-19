package com.example.letsGo.dao.mybatis.mapper;

import com.example.letsGo.domain.product.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerMapper {
    Product addProduct(Product product); // 상품 등록
    Boolean updateProduct(int productId); // 상품 정보 업데이트
    Boolean deleteProduct(int productId); // 상품 삭제
}
