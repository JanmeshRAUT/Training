package com.example.JerryJR.services;

import com.example.JerryJR.entity.Customer;
import com.example.JerryJR.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer SaveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }

    public List<Customer> getCustomerByCity(String city) {
        return customerRepository.findByCity(city);
    }

    public List<Customer> getCustomerByAgeGreaterThan(int age) {
        return customerRepository.findByAgeGreaterThan(age);
    }

    public List<Customer> saveAllCustomers(List<Customer> customers) {

        List<Customer> newCustomers = customers.stream()
                .filter(c -> customerRepository.findByEmail(c.getEmail()).isEmpty())
                .toList();

        return customerRepository.saveAll(newCustomers);
    }

    public Customer updateCustomer(Long id,Customer customer) {
        Customer updatedCustomer = customerRepository.findById(id).orElse(null);
        if (updatedCustomer != null) {
            updatedCustomer.setName(customer.getName());
            updatedCustomer.setCity(customer.getCity());
            updatedCustomer.setAge(customer.getAge());
            updatedCustomer.setEmail(customer.getEmail());
            updatedCustomer.setBankUserName(customer.getBankUserName());
            updatedCustomer.setPassword(customer.getPassword());
            return customerRepository.save(updatedCustomer);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

