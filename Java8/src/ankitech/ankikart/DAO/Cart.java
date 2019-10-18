package ankitech.ankikart.DAO;

import ankitech.ankikart.entity.Product;
import ankitech.ankikart.exception.CartException;

import java.util.List;

public interface Cart {

    public void addToCart(Product product) throws CartException;
    public void list() throws CartException;
    public void removeFromCart(Product product) throws CartException;
    public void saveCart() throws CartException;

}
