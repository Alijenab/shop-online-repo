package com.example.onlineshoptest1.controller;

import com.example.onlineshoptest1.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * author : Ali Eslami
 * mobile : +989117699155
 * email : aljae0719@gmail.com
 */


@RequestMapping("/shop/customer")
public interface CustomerController {


    @PostMapping("/addCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    void addCustomer(@RequestBody Customer customer);


    @PutMapping("/updateCustomer")
    ResponseEntity<?> updateCustomer(@RequestBody Customer customer);


    @GetMapping("/getCustomerById/customerId/{customerId}")
    Optional<Customer> getCustomerById(@PathVariable Long customerId);


    @GetMapping("/getCustomers")
    List<Customer> getCustomers();

}