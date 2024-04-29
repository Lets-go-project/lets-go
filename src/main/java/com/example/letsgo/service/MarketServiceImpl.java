
package com.example.letsgo.service;

import com.example.letsgo.dao.CartDao;
import com.example.letsgo.dao.ManagerDao;
import com.example.letsgo.dao.ProductDao;
import com.example.letsgo.domain.market.Cart;
import com.example.letsgo.domain.market.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private CartDao cartDao;

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
    public Product getDetailProduct(int productId) {
        return productDao.getDetailProduct(productId);
    }
    public List<Product> searchProductByName(String productName) {
        return productDao.searchProductByName(productName);
    }
    public List<Product> searchProductByProductType(int productType) {
        return productDao.searchProductByProductType(productType);
    }
    public Boolean scrapProduct(int productId, int userId) {
        return productDao.scrapProduct(productId, userId);
    }


    public Product addProduct(Product product) {
        return managerDao.addProduct(product);
    }
    public Boolean updateProduct(int productId) {
        return managerDao.updateProduct(productId);
    }
    public Boolean deleteProduct(int productId) {
        return managerDao.deleteProduct(productId);
    }


    public List<Cart> getAllCarts() {
        return cartDao.getAllCarts();
    }
    public Cart addToCart(int cartId) {
        return cartDao.addToCart(cartId);
    }
    public Boolean removeFromCart(int cartId) {
        return cartDao.removeFromCart(cartId);
    }
}
