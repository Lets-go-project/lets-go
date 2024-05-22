package repository;

import domain.market.Cart;
import domain.market.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements MarketRepository{

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getDetailProduct(int productId) {
        return null;
    }

    @Override
    public List<Product> searchProductByName(String productName) {
        return null;
    }

    @Override
    public List<Product> searchProductByProductType(int productType) {
        return null;
    }

    @Override
    public Boolean scrapProduct(int productId, int userId) {
        return null;
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

    @Override
    public List<Cart> getAllCarts() {
        return null;
    }

    @Override
    public Cart addToCart(int cartId) {
        return null;
    }

    @Override
    public Boolean removeFromCart(int cartId) {
        return null;
    }
}
