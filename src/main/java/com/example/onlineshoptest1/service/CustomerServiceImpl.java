package com.example.onlineshoptest1.service;

import com.example.onlineshoptest1.domain.Customer;
import com.example.onlineshoptest1.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    @Override
    public ResponseEntity<?> updateCustomer(Customer customer) {
        Optional<Customer> customerOpt = customerRepository.findById(customer.getId());
        if (customerOpt.isPresent()) {
            customerOpt.get().setDescription(customer.getDescription());
            customerOpt.get().setEmail(customer.getEmail());
            customerOpt.get().setFirstName(customer.getFirstName());
            customerOpt.get().setLastName(customer.getLastName());
            return new ResponseEntity<>(customerRepository.save(customerOpt.get()), null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @Override
    public Optional<Customer> getCustomersById(Long customerId) {
        return customerRepository.findById(customerId);
    }



    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}