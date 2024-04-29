package com.example.letsgo.dao.mybatis;

import com.example.letsgo.dao.ProductDao;
import com.example.letsgo.dao.mybatis.mapper.ProductMapper;
import com.example.letsgo.domain.market.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MyBatisProductDao implements ProductDao {

    private final ProductMapper productMapper;

    @Autowired
    public MyBatisProductDao(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    public Product getDetailProduct(int productId) {
        return productMapper.getDetailProduct(productId);
    }

    public List<Product> searchProductByName(String productName) {
        return productMapper.searchProductByName(productName);
    }

    public List<Product> searchProductByProductType(int productType) {
        return productMapper.searchProductByProductType(productType);
    }

    public Boolean scrapProduct(int productId, int userId) {
        return productMapper.scrapProduct(productId, userId);
    }

}