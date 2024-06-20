package com.example.letsGo.repository;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.market.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayRepository extends JpaRepository<Pay, Long> {
    List<Pay> findByName(String name);
    Pay findByPayId(Long payId);
    List<Pay> findByUser(User user);
}
