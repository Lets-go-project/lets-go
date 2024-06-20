package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.ProductDao;
import com.example.letsGo.dao.mybatis.mapper.ProductMapper;
import com.example.letsGo.domain.product.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Log4j2
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
    public List<Product> searchProductByType(int productType) {
        return productMapper.searchProductByType(productType);
    }

    public Boolean scrapProduct(int productId, int userId) {
        return productMapper.scrapProduct(productId, userId);
    }

}