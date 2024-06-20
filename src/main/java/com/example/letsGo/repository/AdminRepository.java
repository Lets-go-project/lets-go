package com.example.letsGo.repository;

import com.example.letsGo.domain.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByAdminNameAndAdminPw(String adminName, String adminPw);
}
