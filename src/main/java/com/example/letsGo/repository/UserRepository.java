package com.example.letsGo.repository;

import com.example.letsGo.domain.member.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(String id);
    Optional<User> findByPassword(String password);
    Optional<User> findByEmail(String email);
}
