package brs.AI_Shop.Repository;

import brs.AI_Shop.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAll();

    long countByFulfilledFalse();
    long countByFulfilledTrue();
    boolean existsByFulfilledFalse();

    long count();
    @Query(value = "SELECT SUM(price) FROM orders", nativeQuery = true)
    double totalPrice();

    @Query(value = "SELECT SUM(price) FROM orders WHERE day_ordered= ?1", nativeQuery = true)
    double sumPriceByDayOfWeek(String dayOfWeek);

    @Query(value = "SELECT SUM(price) FROM orders WHERE day_ordered= ?1 AND fulfilled=true", nativeQuery = true)
    double sumPriceByDayOfWeekAndFulfilled(String dayOfWeek);

    @Query(value = "SELECT o.sku as sku, COUNT(o.sku) as skuCount " + "FROM orders o " + "GROUP BY o.sku " + "ORDER BY skuCount DESC", nativeQuery = true)
    List<Object[]> findTop5SkusByCount();

    @Query(value = "SELECT * FROM orders WHERE user_id= ?1", nativeQuery = true)
    List<Order> findUserOrders(int user_id);
}