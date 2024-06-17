package com.example.letsGo.repository;

import com.example.letsGo.domain.market.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
