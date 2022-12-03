package com.example.onlineshoptest1.controller;


import com.example.onlineshoptest1.domain.OrderProduct;
import com.example.onlineshoptest1.service.OrderProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class OrderProductControllerImpl implements OrderProductController {


    private final OrderProductService orderProductService;

    @Autowired
    public OrderProductControllerImpl(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }


    @Override
    public ResponseEntity<?> addOrderProduct(OrderProduct orderProduct) {
       return orderProductService.addOrderProduct(orderProduct);
    }


    @Override
    public List<OrderProduct> getOrderProducts() {
        return orderProductService.getOrderProducts();
    }

}