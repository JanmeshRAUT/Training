package com.example.JerryJR.services;

import com.example.JerryJR.entity.Customer;
import com.example.JerryJR.entity.Order;
import com.example.JerryJR.entity.Product;
import com.example.JerryJR.repository.CustomerRepository;
import com.example.JerryJR.repository.OrderRepository;
import com.example.JerryJR.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Order saveOrder(Long customerId, Long productId, Integer quantity) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        if (product.getStock() < quantity) {
            throw new RuntimeException(
                    "Insufficient stock. Available: " + product.getStock()
            );
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        Order order = new Order();
        order.setCustomer(customer);
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setPrice(product.getProductPrice() * quantity);

        return orderRepository.save(order);
    }

    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void deleteOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = order.getProduct();

        product.setStock(product.getStock() + order.getQuantity());

        productRepository.save(product);

        orderRepository.delete(order);
    }

    public List<Customer> findCustomersByProductId(Long productId) {

        List<Order> orders = orderRepository.findByProduct_ProductId(productId);

        List<Customer> customers = new ArrayList<>();

        for (Order order : orders) {
            customers.add(order.getCustomer());
        }

        return customers;
    }

    public Integer countOrdersByCustomerId(Long customerId) {
        return orderRepository.countOrdersByCustomerId(customerId).intValue();
    }

    public Double calculateTotalPriceByCustomerId(Long customerId) {

        Double total = orderRepository.calculateTotalPrice(customerId);

        return total == null ? 0.0 : total;
    }

    public Double calculateTotalRevenue() {

        Double revenue = orderRepository.calculateTotalRevenue();

        return revenue == null ? 0.0 : revenue;
    }


}