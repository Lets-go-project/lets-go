package com.example.letsGo.service;

import com.example.letsGo.dao.UserDao;
import com.example.letsGo.domain.market.ProductScrap;
import com.example.letsGo.domain.member.User;
import com.example.letsGo.repository.ProductScrapRepository;
import com.example.letsGo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsScrapServiceImpl implements ProductsScrapService {
    private final UserDao userDao;
    @Autowired
    private ProductScrapRepository productScrapRepository;

    @Autowired
    private UserRepository userRepository;

    public ProductsScrapServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<ProductScrap> getProductScrapsByUser(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null; // or throw an exception
        }
        return productScrapRepository.findByUser(user);
    }
}
