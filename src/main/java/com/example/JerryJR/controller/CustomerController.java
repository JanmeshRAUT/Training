package com.example.JerryJR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    List<Customer> getCustomerByCity(@PathVariable String city) {
        return service.getCustomerByCity(city);
    }

    @GetMapping("age/{age}")
    List<Customer> getCustomerByAgeGreaterThan(@PathVariable int age) {
        return service.getCustomerByAgeGreaterThan(age);
    }

    @PutMapping("id/{id}")
    Customer UpdateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return service.updateCustomer(id, customer);
    }

    @DeleteMapping("id/{id}")
    Customer DeleteCustomer(@PathVariable Long id) {
        Customer customer = service.getCustomerById(id);
        if(customer != null) {
            service.deleteCustomer(id);
            return customer;
        }
        return null;
    }


}
