package com.example.letsGo.repository;

import com.example.letsGo.domain.pool.Pool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoolRepository extends JpaRepository<Pool, String> {
}