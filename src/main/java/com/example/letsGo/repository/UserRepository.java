package com.example.letsGo.repository;

import com.example.letsGo.domain.member.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(String id);
    User findByPassword(String password);
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.user_id = :userId")
    User findByUser_id(@Param("userId") int userId);

}
