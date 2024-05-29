package dao;

import domain.market.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts(); // 모든 상품 조회
    Product getDetailProduct(int productId); // 상품 상세페이지 조회
    List<Product> searchProductByName(String productName); // 상품 검색
    List<Product> searchProductByProductType(int productType); // 상품 타입별 필터링
    Boolean scrapProduct(int productId, int userId); // 상품 스크랩
}
