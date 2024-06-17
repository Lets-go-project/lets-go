package com.example.letsGo.repository;

import com.example.letsGo.domain.member.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(String id);
    User findByUserId(int id);

}
