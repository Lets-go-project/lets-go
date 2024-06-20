package com.example.letsGo.service;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.product.ProductScrap;

import java.util.List;

public interface ProductsScrapService {
    List<ProductScrap> getProductScrapsByUser(int userId);

}
