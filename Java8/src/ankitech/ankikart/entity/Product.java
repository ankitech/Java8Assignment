package ankitech.ankikart.entity;

import ankitech.ankikart.annotation.Column;
import ankitech.ankikart.annotation.Table;

import java.util.Objects;

@Table(name = "cart")
public class Product {

    @Column(columnName = "id")
    int catId;

    @Column(columnName = "prodId")
    int productId;

    transient String productName;
    transient String productDescription;

    @Column(columnName = "prodPrice")
    float productPrice;

    public Product(int catId, int productId, String productName, String productDescription, float productPrice) {
        this.catId = catId;
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return String.format("Product{ catId= %d, productId= %d, productName=' %s, productDescription=' %s, productPrice= %f}",
                catId,productId,productName,productDescription,productPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
