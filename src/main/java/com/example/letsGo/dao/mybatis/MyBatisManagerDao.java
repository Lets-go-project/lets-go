package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.ManagerDao;
import com.example.letsGo.dao.mybatis.mapper.ManagerMapper;
import com.example.letsGo.domain.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisManagerDao implements ManagerDao {

    private final ManagerMapper managerMapper;

    public MyBatisManagerDao(ManagerMapper managerMapper) {
        this.managerMapper = managerMapper;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Boolean updateProduct(int productId) {
        return null;
    }

    @Override
    public Boolean deleteProduct(int productId) {
        return null;
    }
}