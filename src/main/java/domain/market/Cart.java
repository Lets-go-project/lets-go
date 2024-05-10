package domain.market;

import java.io.Serializable;

public class Cart implements Serializable {
    private int cartId;
    private int amount;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
