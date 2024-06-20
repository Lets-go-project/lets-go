package com.example.letsGo.service;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.product.ProductScrap;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.ProductScrapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductScrapService {
    @Autowired
    private ProductScrapRepository productScrapRepository;

    public List<ProductScrap> getProductScrapsByUser(User user) {
        return productScrapRepository.findByUser(user);
    }
}