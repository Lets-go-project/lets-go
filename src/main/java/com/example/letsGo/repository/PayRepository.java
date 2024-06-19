package com.example.letsGo.repository;

import com.example.letsGo.domain.product.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay, Long> {
//    List<Pay> findByName(String name);
//    Pay findByOrderId(Long orderId);
}
