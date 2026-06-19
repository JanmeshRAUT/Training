package com.example.JerryJR.services;

import com.example.JerryJR.entity.Customer;
import com.example.JerryJR.entity.Order;
import com.example.JerryJR.entity.Product;
import com.example.JerryJR.repository.CustomerRepository;
import com.example.JerryJR.repository.OrderRepository;
import com.example.JerryJR.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Order SaveOrder(Long customerId, Long productId, Integer quantity) {
        Customer customer=customerRepository.findById(customerId).orElse(null);
        if(customer != null) {
            Product product = productRepository.findById(productId).orElse(null);

            if (product != null) {
                if (product.getStock() >= quantity) {
                    product.setStock(product.getStock() - quantity);
                    productRepository.save(product);

                    Order order = new Order();
                    order.setCustomer(customer);
                    order.setProduct(product);
                    order.setQuantity(quantity);
                    order.setPrice(product.getProductPrice() * quantity);
                    return orderRepository.save(order);
                } else {
                    throw new RuntimeException("Insufficient stock. Available: " + product.getStock());
                }
            } else {
                throw new RuntimeException("Product Not Found");
            }
        } else {
            throw new RuntimeException("Customer Not Found");
        }
    }

    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(orderId);
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
        return orderRepository.calculateTotalPrice(customerId);
    }
    public Double calculateTotalRevenue(){
        return orderRepository.calculateTotalRevenue();
    }

    public Order updateOrder(Long orderId, Long productId, Integer quantity) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product oldProduct = order.getProduct();

        // Restore stock from the existing order
        oldProduct.setStock(oldProduct.getStock() + order.getQuantity());
        productRepository.save(oldProduct);

        Product newProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (newProduct.getStock() < quantity) {
            throw new RuntimeException(
                    "Insufficient stock. Available: " + newProduct.getStock()
            );
        }

        // Deduct stock for updated order
        newProduct.setStock(newProduct.getStock() - quantity);
        productRepository.save(newProduct);

        // Update order details
        order.setProduct(newProduct);
        order.setQuantity(quantity);
        order.setPrice(newProduct.getProductPrice() * quantity);

        return orderRepository.save(order);
    }




}