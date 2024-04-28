package com.example.letsgo.dao.mybatis;

import com.example.letsgo.dao.ProductDao;
import com.example.letsgo.dao.mybatis.mapper.ProductMapper;
import com.example.letsgo.domain.market.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
@Repository
public class MyBatisProductDao implements ProductDao {

    private final ProductMapper productMapper;

    @Autowired
    public MyBatisProductDao(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Override
    public Product getDetailProduct(int productId) {
        return productMapper.getDetailProduct(productId);
    }

    @Override
    public List<Product> searchProductByName(String productName) {
        return productMapper.searchProductByName(productName);
    }

    @Override
    public List<Product> searchProductByProductType(int productType) {
        return productMapper.searchProductByProductType(productType);
    }
}