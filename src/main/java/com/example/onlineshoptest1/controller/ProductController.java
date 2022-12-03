package com.example.onlineshoptest1.controller;

import com.example.onlineshoptest1.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author : Ali Eslami
 * mobile : +989117699155
 * email : aljae0719@gmail.com
 */


@RequestMapping("/shop/product")
public interface ProductController {


    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    void addProduct(@RequestBody Product product);


    @PutMapping("/updateProduct")
    ResponseEntity<?> updateProduct(@RequestBody Product product);


    @GetMapping("/getProductsById/productId/{productId}")
    List<Product> getProductsById(@PathVariable Long productId);


}