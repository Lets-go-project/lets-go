package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.SalesManagerDao;
import com.example.letsGo.dao.mybatis.mapper.ManagerMapper;
import com.example.letsGo.domain.market.Product;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisSalesManagerDao implements SalesManagerDao {

    private final ManagerMapper managerMapper;

    public MyBatisSalesManagerDao(ManagerMapper managerMapper) {
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