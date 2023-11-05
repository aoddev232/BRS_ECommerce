package brs.AI_Shop.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    private int order_number;
    @Column(nullable = false)
    private int sku;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int user_id;
    @Column(nullable = false)
    private boolean fulfilled;

    @Column(nullable = false)
    private String day_ordered;

    public static int order_count = 115;

    public Order() {}

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public String getDay_ordered() {
        return day_ordered;
    }

    public void setDay_ordered(String day_ordered) {
        this.day_ordered = day_ordered;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
