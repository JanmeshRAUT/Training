package com.example.JerryJR.controller;

import com.example.JerryJR.entity.Customer;
import com.example.JerryJR.entity.Order;
import com.example.JerryJR.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/id/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @PostMapping("/{customerId}/{productId}/{quantity}")
    public Order createOrder(
            @PathVariable Long customerId,
            @PathVariable Long productId,
            @PathVariable Integer quantity) {

        return orderService.saveOrder(customerId, productId, quantity);
    }

    @DeleteMapping("/id/{id}")
    public String deleteOrder(@PathVariable Long id) {

        orderService.deleteOrder(id);

        return "Order deleted successfully";
    }

    @GetMapping("/product/{productId}/customers")
    public List<Customer> findCustomersByProductId(@PathVariable Long productId) {
        return orderService.findCustomersByProductId(productId);
    }

    @GetMapping("/customer/{customerId}/count")
    public Integer countOrdersByCustomerId(@PathVariable Long customerId) {
        return orderService.countOrdersByCustomerId(customerId);
    }

    @GetMapping("/customer/{customerId}/total")
    public Double calculateTotalPriceByCustomerId(@PathVariable Long customerId) {
        return orderService.calculateTotalPriceByCustomerId(customerId);
    }

    @GetMapping("/revenue")
    public Double calculateTotalRevenue() {
        return orderService.calculateTotalRevenue();
    }
}