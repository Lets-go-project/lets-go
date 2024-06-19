package com.example.letsGo.repository;

import com.example.letsGo.domain.product.Cart;
import com.example.letsGo.domain.member.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(Optional<User> user);
}
