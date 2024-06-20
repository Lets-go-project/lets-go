package com.example.letsGo.repository;


import com.example.letsGo.domain.pool.PoolScrapMapping;
import com.example.letsGo.domain.pool.PoolScrapMappingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PoolScrapMappingRepository extends JpaRepository<PoolScrapMapping, PoolScrapMappingId> {

    @Query("SELECT p FROM PoolScrapMapping p WHERE p.id.userId = :userId")
    List<PoolScrapMapping> findByUserId(@Param("userId") int userId);
}