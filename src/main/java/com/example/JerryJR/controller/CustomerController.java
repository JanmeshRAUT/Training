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
    List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PostMapping
    Customer SaveCustomer(@RequestBody Customer customer) {
        return service.SaveCustomer(customer);
    }

    @PostMapping("/saveAll")
    public List<Customer> saveAllCustomers(@RequestBody List<Customer> customers) {
        return service.saveAllCustomers(customers);
    }

    @GetMapping("id/{id}")
    Customer getCustomerById(@PathVariable Long id) {
        if(id == null) {
            return null;
        }
        return service.getCustomerById(id);
    }


    @GetMapping("id/{id}")
    Customer getCustomerByEmail(@PathVariable String email) {
        if(id == null || email.equals("")) {
            return null;
        }
        return service.getCustomerByEmail(email);
    }

    List<Customer> getCustomerByCity(String city) {
        return null;
    }

    List<Customer> getCustomerByAgeGreaterThan(int age) {
        return null;
    }
}
