package com.example.letsGo.dao;

import com.example.letsGo.domain.member.User;

public interface UserDao {
    User findById(String id);
    void save(User user);

    User findByEmail(String email);

    User findByPassword(String password);

    void update(User user);
}
