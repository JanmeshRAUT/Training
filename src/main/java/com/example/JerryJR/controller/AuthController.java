package com.example.JerryJR.controller;

import com.example.JerryJR.dto.AuthResponse;
import com.example.JerryJR.dto.LoginRequest;
import com.example.JerryJR.dto.RegisterRequest;
import com.example.JerryJR.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        customerService.registerCustomer(request);
        return new ResponseEntity<>(new AuthResponse("Customer Registered Successfully"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        String result = customerService.loginCustomer(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity<>(new AuthResponse(result), HttpStatus.OK);
    }
}