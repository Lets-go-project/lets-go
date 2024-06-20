
package com.example.letsGo.service;

import com.example.letsGo.dao.mybatis.MyBatisCartDao;
import com.example.letsGo.dao.mybatis.MyBatisSalesManagerDao;
import com.example.letsGo.dao.mybatis.MyBatisProductDao;
import com.example.letsGo.domain.product.Product;
//import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.ProductScrapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private final MyBatisProductDao productDao;
    private final MyBatisSalesManagerDao managerDao;
    private final MyBatisCartDao cartDao;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductScrapRepository productScrapRepository;


    @Autowired
    public ProductServiceImpl(MyBatisProductDao productDao, MyBatisSalesManagerDao managerDao, MyBatisCartDao cartDao) {
        this.productDao = productDao;
        this.managerDao = managerDao;
        this.cartDao = cartDao;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public Product getDetailProduct(int productId) {
        return productDao.getDetailProduct(productId);
    }

    @Override
    public List<Product> searchProductByName(String productName) {
        return productDao.searchProductByName(productName);
    }

    @Override
    public List<Product> searchProductByType(int productType) {
        return productDao.searchProductByType(productType);
    }

    @Override
    public Boolean scrapProduct(int productId, int userId) {
        return productDao.scrapProduct(productId, userId);
    }

}
