package com.example.letsGo.service;


import com.example.letsGo.domain.market.ProductScrap;

import java.util.List;

public interface ProductsScrapService {
    List<ProductScrap> getProductScrapsByUser(int userId);

}
