package com.example.onlineshoptest1.service;


import com.example.onlineshoptest1.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/**
 * author : Ali Eslami
 * mobile : +989117699155
 * email : aljae0719@gmail.com
 */

public interface CustomerService {


    void addCustomer(@RequestBody Customer customer);


    ResponseEntity<?> updateCustomer(@RequestBody Customer customer);


    Optional<Customer> getCustomersById(@PathVariable Long customerId);


    List<Customer> getCustomers();


}