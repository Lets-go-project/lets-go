package dao.mybatis;

import dao.CartDao;
import dao.ProductDao;
import dao.mybatis.mapper.CartMapper;
import dao.mybatis.mapper.ProductMapper;
import domain.market.Cart;
import domain.market.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisCartDao implements CartDao {
    private final CartMapper cartMapper;

    public MyBatisCartDao(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartMapper.getAllCarts();
    }

    @Override
    public Cart addToCart(int cartId) {
        return cartMapper.addToCart(cartId);
    }

    @Override
    public Boolean removeFromCart(int cartId) {
        return null;
    }
}