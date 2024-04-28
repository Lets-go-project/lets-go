
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
    MarketService marketService;

    public List<Product> getAllProducts() {
        return marketService.getAllProducts();
    }

    public Product getDetailProduct(int productId) {
        return marketService.getDetailProduct(productId);
    }

    public List<Product> searchProductByName(String productName) {
        return marketService.searchProductByName(productName);
    }

    public List<Product> searchProductByProductType(int productType) {
        return marketService.searchProductByProductType(productType);
    }

    public Product addProduct(Product product) {
        return marketService.addProduct(product);
    }

    public Boolean updateProduct(Product product) {
        return marketService.updateProduct(product);
    }

    public Boolean deleteProduct(int productId) {
        return marketService.deleteProduct(productId);
    }

    public List<Cart> getAllCarts() {
        return marketService.getAllCarts();
    }

    public Cart addToCart(Cart cart) {
        return marketService.addToCart(cart);
    }

    public Boolean removeFromCart(int cartId) {
        return marketService.removeFromCart(cartId);
    }
}
