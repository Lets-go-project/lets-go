package com.example.letsGo.service;

import com.example.letsGo.domain.admin.Admin;
import com.example.letsGo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean validateAdmin(String adminName, String adminPw) {
        Admin admin = adminRepository.findByAdminNameAndAdminPw(adminName, adminPw);
        return admin != null;
    }
}