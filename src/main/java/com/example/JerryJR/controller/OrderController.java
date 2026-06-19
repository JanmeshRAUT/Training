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
        if (id == null) {
            return null;
        }
        return orderService.findOrderById(id);
    }

    @PostMapping("/{customerId}/{productId}/{quantity}")
    public Order createOrder(@PathVariable Long customerId, @PathVariable Long productId, @PathVariable Integer quantity) {
        return orderService.SaveOrder(customerId, productId, quantity);
    }



    @DeleteMapping("/id/{id}")
    public Order deleteOrder(@PathVariable Long id) {
        Order order = orderService.findOrderById(id);
        if (order != null) {
            orderService.deleteOrder(id);
            return order;
        }
        return null;
    }

    @GetMapping("/product/{productId}/customers")
    public List<Customer> findCustomersByProductId(@PathVariable Long productId) {
        return orderService.findCustomersByProductId(productId);
    }
}
