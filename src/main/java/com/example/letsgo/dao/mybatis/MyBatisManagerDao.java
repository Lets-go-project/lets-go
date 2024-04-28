package com.example.letsgo.dao.mybatis;

import com.example.letsgo.dao.ManagerDao;
import com.example.letsgo.dao.ProductDao;
import com.example.letsgo.dao.mybatis.mapper.ManagerMapper;
import com.example.letsgo.dao.mybatis.mapper.ProductMapper;
import com.example.letsgo.domain.market.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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