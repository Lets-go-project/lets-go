package com.example.letsGo.service;

import com.example.letsGo.domain.product.Cart;
import com.example.letsGo.domain.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts(); // 모든 상품 조회
    Product getDetailProduct(int productId); // 상품 상세페이지 조회
    List<Product> searchProductByName(String productName); // 상품 검색
    List<Product> searchProductByType(int productType); // 상품 검색
    List<Product> getProductByProductType(int productType); // 상품 타입별 조회
    Boolean scrapProduct(int productId, int userId);

    Product addProduct(Product product); // 상품 등록
    Boolean updateProduct(int productId); // 상품 정보 업데이트
    Boolean deleteProduct(int productId); // 상품 삭제

    List<Cart> getAllCarts();   // 장바구니 조회
    Cart addToCart(int cartId);  // 장바구니에 상품 추가
    Boolean removeFromCart(int cartId); // 장바구니 전체/선택 삭제

}
