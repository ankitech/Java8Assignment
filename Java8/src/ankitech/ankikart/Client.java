package ankitech.ankikart;

import ankitech.ankikart.DAO.Cart;
import ankitech.ankikart.entity.Product;
import ankitech.ankikart.exception.CartException;
import ankitech.ankikart.factory.CartFactory;

public class Client {
    public static void main(String[] args) throws CartException {

        CartFactory cartFactory = new CartFactory();

        Cart shoppingCart = cartFactory.getCartInstance();

        shoppingCart.addToCart(new Product
                (1, 2, "phone", "tring-tring", 100f));
        shoppingCart.addToCart(new Product
                (1, 3, "charger", "tring-tring", 10f));
        shoppingCart.addToCart(new Product
                (1, 4, "earphone", "tring-tring", 20f));
        shoppingCart.removeFromCart(new Product
                (1, 2, "phone", "tring-tring", 100f));

        shoppingCart.list();

        shoppingCart.saveCart();

    }
}
