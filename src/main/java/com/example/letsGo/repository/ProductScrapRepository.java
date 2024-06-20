package com.example.letsGo.repository;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.market.Product;
import com.example.letsGo.domain.market.ProductScrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductScrapRepository extends JpaRepository<ProductScrap, Integer> {
    ProductScrap findByUserAndProduct(User user, Product product);
}