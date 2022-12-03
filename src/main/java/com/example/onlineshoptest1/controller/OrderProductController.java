package com.example.onlineshoptest1.controller;

import com.example.onlineshoptest1.domain.OrderProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author : Ali Eslami
 * mobile : +989117699155
 * email : aljae0719@gmail.com
 */


@RequestMapping("/shop/order")
public interface OrderProductController {


    @PostMapping("/addOrderProduct")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> addOrderProduct(@RequestBody OrderProduct orderProduct);


    @GetMapping("/getOrderProducts")
    List<OrderProduct> getOrderProducts();




}