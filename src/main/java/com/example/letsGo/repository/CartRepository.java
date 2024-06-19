package com.example.letsGo.repository;

import com.example.letsGo.domain.product.Cart;
import com.example.letsGo.domain.member.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
}