package com.example.JerryJR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JerryJR.entity.Customer;
import com.example.JerryJR.services.CustomerService;

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


    @GetMapping("email/{email}")
    Customer getCustomerByEmail(@PathVariable String email) {
        if(email == null || email.equals("")) {
            return null;
        }
        return service.getCustomerByEmail(email);
    }

    @GetMapping("city/{city}")
    List<Customer> getCustomerByCity(String city) {
        return service.getCustomerByCity(city);
    }

    @GetMapping("age/{age}")
    List<Customer> getCustomerByAgeGreaterThan(int age) {
        return service.getCustomerByAgeGreaterThan(age);
    }
}
