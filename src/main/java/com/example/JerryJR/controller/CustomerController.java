package com.example.JerryJR.controller;

import com.example.JerryJR.entity.Customer;
import com.example.JerryJR.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PostMapping("/saveAll")
    public List<Customer> saveAllCustomers(@RequestBody List<Customer> customers) {
        return service.saveAllCustomers(customers);
    }

    @GetMapping("/id/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping("/email/{email}")
    public Customer getCustomerByEmail(@PathVariable String email) {
        return service.getCustomerByEmail(email);
    }

    @GetMapping("/city/{city}")
    public List<Customer> getCustomerByCity(@PathVariable String city) {
        return service.getCustomerByCity(city);
    }

    @GetMapping("/age/{age}")
    public List<Customer> getCustomerByAgeGreaterThan(@PathVariable int age) {
        return service.getCustomerByAgeGreaterThan(age);
    }

    @PutMapping("/id/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return service.updateCustomer(id, customer);
    }

    @DeleteMapping("/id/{id}")
    public Customer deleteCustomer(@PathVariable Long id) {
        Customer customer = service.getCustomerById(id);

        if (customer != null) {
            service.deleteCustomer(id);
        }

        return customer;
    }
}