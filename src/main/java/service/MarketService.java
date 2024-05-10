package service;

import domain.market.Cart;
import domain.market.Product;

import java.util.List;

public interface MarketService {
    List<Product> getAllProducts(); // 모든 상품 조회
    Product getDetailProduct(int productId); // 상품 상세페이지 조회
    List<Product> searchProductByName(String productName); // 상품 검색
    List<Product> searchProductByProductType(int productType); // 상품 타입별 조회
    Boolean scrapProduct(int productId, int userId);

    Product addProduct(Product product); // 상품 등록
    Boolean updateProduct(int productId); // 상품 정보 업데이트
    Boolean deleteProduct(int productId); // 상품 삭제

    List<Cart> getAllCarts();   // 장바구니 조회
    Cart addToCart(int cartId);  // 장바구니에 상품 추가
    Boolean removeFromCart(int cartId); // 장바구니 전체/선택 삭제

}
