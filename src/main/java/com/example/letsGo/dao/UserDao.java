package com.example.letsGo.dao;

import com.example.letsGo.domain.member.User;

public interface UserDao {
    User findById(String id);
}
