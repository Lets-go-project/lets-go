package com.example.letsGo.repository;

import com.example.letsGo.domain.salesmanager.SalesManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesManagerRepository extends JpaRepository<SalesManager, Long> {
}
