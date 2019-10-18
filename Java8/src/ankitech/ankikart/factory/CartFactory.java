package ankitech.ankikart.factory;

import ankitech.ankikart.DAO.Cart;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CartFactory {

    public Cart getCartInstance() {

        Properties dbProps = new Properties();
        Cart cart = null;
        try {
            dbProps.load(new FileInputStream("Application.properties"));
            String cartClass = dbProps.getProperty("app.cartClass");
            cart = (Cart) Class.forName(cartClass).newInstance();

        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return cart;
    }
}
