package com.example.letsGo.dao.mybatis.mapper;

import com.example.letsGo.domain.member.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    User findById(String id);
    void save(User user);

    User findByEmail(String email);

    User findByPassword(String password);

    void update(User user);
}