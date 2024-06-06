package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.UserDao;
import com.example.letsGo.dao.mybatis.mapper.UserMapper;
import com.example.letsGo.domain.member.User;
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

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public User findByPassword(String password) {
        return userMapper.findByPassword(password);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
