
package com.example.letsGo.service;

import com.example.letsGo.dao.mybatis.MyBatisCartDao;
import com.example.letsGo.dao.mybatis.MyBatisManagerDao;
import com.example.letsGo.dao.mybatis.MyBatisProductDao;
import com.example.letsGo.domain.market.Cart;
import com.example.letsGo.domain.market.Product;
import com.example.letsGo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarketServiceImpl implements MarketService {
    private final MyBatisProductDao productDao;
    private final MyBatisManagerDao managerDao;
    private final MyBatisCartDao cartDao;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public MarketServiceImpl(MyBatisProductDao productDao, MyBatisManagerDao managerDao, MyBatisCartDao cartDao) {
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
//        return productRepository.findById(productId);
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
    public List<Product> getProductByProductType(int productType) {
        return productDao.getProductByProductType(productType);
    }

    @Override
    public Boolean scrapProduct(int productId, int userId) {
        return productDao.scrapProduct(productId, userId);
    }

    @Override
    public Product addProduct(Product product) {
        return managerDao.addProduct(product);
    }

    @Override
    public Boolean updateProduct(int productId) {
        return managerDao.updateProduct(productId);
    }

    @Override
    public Boolean deleteProduct(int productId) {
        return managerDao.deleteProduct(productId);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartDao.getAllCarts();
    }

    @Override
    public Cart addToCart(int cartId) {
        return cartDao.addToCart(cartId);
    }

    @Override
    public Boolean removeFromCart(int cartId) {
        return cartDao.removeFromCart(cartId);
    }
}
