package com.example.JerryJR.controller;

import com.example.JerryJR.dto.LoginRequest;
import com.example.JerryJR.entity.Customer;
import com.example.JerryJR.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return customerService.loginCustomer(loginRequest.getEmail(), loginRequest.getPassword());
    }

}
