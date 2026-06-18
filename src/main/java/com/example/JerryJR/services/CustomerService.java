package com.example.JerryJR.services;

import com.example.JerryJR.dto.CustomerDto;
import com.example.JerryJR.entity.Customer;
import com.example.JerryJR.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer SaveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer getCustomerByEmail(String email){
        return customerRepository.findByEmail(email).orElse(null);
    }

    public List<Customer> getCustomerByCity(String city){
        return customerRepository.findByCity(city);
    }

    public List<Customer> getCustomerByAgeGreaterThan(int age){
        return customerRepository.findByAgeGreaterThan(age);
    }

    public List<Customer> saveAllCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }
}
