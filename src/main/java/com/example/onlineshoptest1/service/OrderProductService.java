package com.example.onlineshoptest1.service;


import com.example.onlineshoptest1.domain.OrderProduct;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * author : Ali Eslami
 * mobile : +989117699155
 * email : aljae0719@gmail.com
 */

public interface OrderProductService {


    ResponseEntity<?> addOrderProduct(OrderProduct orderProduct);


    List<OrderProduct> getOrderProducts();


}