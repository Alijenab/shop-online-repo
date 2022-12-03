package com.example.onlineshoptest1.controller;

import com.example.onlineshoptest1.domain.Customer;
import com.example.onlineshoptest1.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void addCustomer(Customer customer) {

        customerService.addCustomer(customer);
    }

    @Override
    public ResponseEntity<?> updateCustomer(Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerService.getCustomersById(customerId);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }


}