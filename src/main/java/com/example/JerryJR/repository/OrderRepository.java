package com.example.JerryJR.repository;

import com.example.JerryJR.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
        SELECT COUNT(o)
        FROM Order o
        WHERE o.customer.id = :customerId
        """)
    Long countOrdersByCustomerId(@Param("customerId") Long customerId);

    @Query("""
        SELECT SUM(o.price)
        FROM Order o
        WHERE o.customer.id = :customerId
        """)
    Double calculateTotalPrice(@Param("customerId") Long customerId);

    @Query("""
        SELECT SUM(o.price)
        FROM Order o
        """)
    Double calculateTotalRevenue();

    List<Order> findByCustomer_Id(Long customerId);

    List<Order> findByProduct_ProductId(Long productId);
}