package brs.AI_Shop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private int sku;
    private String product_name;

    private String description;
    private double price;
    private boolean trained;

    private double trained_price;

    private String product_image;

    public Product(){}

    public Product(int sku, String product_name, String description, double price, boolean trained, double trained_price, String product_image) {
        this.sku = sku;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
        this.trained = trained;
        this.trained_price = trained_price;
        this.product_image = product_image;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    public double getTrained_price() {
        return trained_price;
    }

    public void setTrained_price(double trained_price) {
        this.trained_price = trained_price;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
}
