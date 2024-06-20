package com.example.letsGo.repository;

import com.example.letsGo.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductType(int productType);
    List<Product> findByProductName(String name);
    Product findByProductId(Long productId);

    List<Product> findByIsAccept(int isAccept);

}
