package ankitech.ankikart.DAO;

import ankitech.ankikart.entity.Product;
import ankitech.ankikart.exception.CartException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ShoppingCartImpl implements Cart, AutoCloseable {

    private Connection connection = null;
    private PreparedStatement psAllProducts = null;
    private PreparedStatement psSaveProduct = null;
    private ResultSet resultSet = null;

    List<Product> productList = new ArrayList<>();

    public ShoppingCartImpl() {
        initialize();
    }

    public void initialize() {
        try {
            Properties dbProps = new Properties();
            dbProps.load(new FileInputStream("Application.properties"));
            String dbUrl = dbProps.getProperty("db.url");
            String dbUser = dbProps.getProperty("db.username");
            String dbPassword = dbProps.getProperty("db.password");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void addToCart(Product product) throws CartException {
        productList.add(product);
    }

    @Override
    public void list() throws CartException {
        productList.forEach(System.out ::println);
    }

    @Override
    public void removeFromCart(Product product) throws CartException {
        productList.remove(product);
    }

    @Override
    public void saveCart() {
        try {
            saveAllproducts(productList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    void saveAllproducts(List<Product> products) throws Exception {

        psSaveProduct = connection.prepareStatement("insert into ideas.cart" +
                "('cartid','catid','prodid','prodprice') " +
                "values (?,?,?,?)");


        Product.class.getAnnotations()[]

        Supplier<String> randomCart = () -> {
            char[] charSet = {'A','B','C','D','E','4','5','6','7','8'};
            String id = "";
            for (int i = 0; i < 4; i++) {
                int rand = (int) (Math.random() * 9);
                id += id + charSet[rand];
            }
            return id;
        };

        Consumer<Product> saveProd = product -> {
            try {
                psSaveProduct.setString(1, randomCart.get());
                psSaveProduct.setInt(2, product.getCatId());
                psSaveProduct.setInt(3, product.getProductId());
                psSaveProduct.setFloat(4, product.getProductPrice());
                psSaveProduct.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    psSaveProduct.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };

        productList.forEach(saveProd);
    }

}
