package com.example.letsGo.repository;

import com.example.letsGo.domain.market.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductType(int productType);
    List<Product> findByProductName(String name);
    Product findByProductId(Long productId);
}
