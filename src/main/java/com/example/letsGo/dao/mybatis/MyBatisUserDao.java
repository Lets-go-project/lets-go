package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.UserDao;
import com.example.letsGo.domain.member.User;
import com.example.letsGo.dao.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisUserDao implements UserDao {

    private final UserMapper userMapper;

    @Autowired
    public MyBatisUserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }
}
