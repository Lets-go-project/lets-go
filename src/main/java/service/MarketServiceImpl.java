
package service;

import dao.mybatis.MyBatisCartDao;
import dao.mybatis.MyBatisManagerDao;
import dao.mybatis.MyBatisProductDao;
import domain.market.Cart;
import domain.market.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarketServiceImpl implements MarketService {
    private final MyBatisProductDao productDao;
    private final MyBatisManagerDao managerDao;
    private final MyBatisCartDao cartDao;

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
        return productDao.getDetailProduct(productId);
    }

    @Override
    public List<Product> searchProductByName(String productName) {
        return productDao.searchProductByName(productName);
    }

    @Override
    public List<Product> searchProductByProductType(int productType) {
        return productDao.searchProductByProductType(productType);
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
