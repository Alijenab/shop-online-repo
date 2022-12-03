package com.example.onlineshoptest1.service;


import com.example.onlineshoptest1.domain.Product;
import com.example.onlineshoptest1.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/**
 * author : Ali Eslami
 * mobile : +989117699155
 * email : aljae0719@gmail.com
 */

public interface ProductService {



    void addProduct(@RequestBody Product product);


    ResponseEntity<?> updateProduct(@RequestBody Product product);


    List<Product> getProductsById(@PathVariable Long productId);



}