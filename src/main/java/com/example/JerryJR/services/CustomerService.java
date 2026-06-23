package com.example.JerryJR.services;

import com.example.JerryJR.dto.RegisterRequest;
import com.example.JerryJR.entity.Customer;
import com.example.JerryJR.exception.EmailAlreadyExistsException;
import com.example.JerryJR.exception.InvalidPasswordException;
import com.example.JerryJR.exception.UserNotFoundException;
import com.example.JerryJR.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // =====================
    // CRUD OPERATIONS
    // =====================

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
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
                .filter(c ->
                        customerRepository
                                .findByEmail(c.getEmail())
                                .isEmpty())
                .toList();

        return customerRepository.saveAll(newCustomers);
    }

    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer =
                customerRepository.findById(id)
                        .orElse(null);

        if (existingCustomer != null) {

            existingCustomer.setName(customer.getName());
            existingCustomer.setCity(customer.getCity());
            existingCustomer.setAge(customer.getAge());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setBankUserName(customer.getBankUserName());

            if (customer.getPassword() != null && !customer.getPassword().isEmpty() && !customer.getPassword().startsWith("$2a$")) {
                existingCustomer.setPassword(passwordEncoder.encode(customer.getPassword()));
            } else {
                existingCustomer.setPassword(customer.getPassword());
            }

            return customerRepository.save(existingCustomer);
        }

        return null;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }



    public void registerCustomer(RegisterRequest request) {

        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        Customer customer = new Customer();

        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setCity(request.getCity());
        customer.setAge(request.getAge());
        customer.setBankUserName(request.getBankUserName());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));

        customerRepository.save(customer);
    }

    public String loginCustomer(String email, String password) {

        Customer customer =customerRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User Not Found"));

        if (!passwordEncoder.matches(password, customer.getPassword())) {
            throw new InvalidPasswordException("Invalid Password");
        }

        return "Login Successful";
    }
}