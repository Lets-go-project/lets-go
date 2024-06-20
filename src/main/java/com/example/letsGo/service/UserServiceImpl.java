package com.example.letsGo.service;

import com.example.letsGo.dao.UserDao;
import com.example.letsGo.domain.member.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }



    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userDao.findById(id);
    }



    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User getUserByPassword(String password) {
        return userDao.findByPassword(password);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public User getUserByUserId(int userId) {
       return userDao.findByUserId(userId);
    }
}