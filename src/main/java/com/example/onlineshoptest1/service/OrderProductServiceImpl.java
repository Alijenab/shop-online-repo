package com.example.onlineshoptest1.service;

import com.example.onlineshoptest1.domain.OrderProduct;
import com.example.onlineshoptest1.repository.OrderProductRepository;
import com.example.onlineshoptest1.repository.ProductRepository;
import jakarta.persistence.LockModeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class OrderProductServiceImpl implements OrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderProductServiceImpl(OrderProductRepository orderProductRepository, ProductRepository productRepository) {
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;
    }


    @Override
    //transactional query that sure everything is done
    @Transactional(isolation = Isolation.READ_COMMITTED , rollbackFor = Exception.class , timeout = 30 , propagation = Propagation.NEVER)
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT) // Lock this query to done successfully
    public ResponseEntity<?> addOrderProduct(OrderProduct orderProduct) {
        HttpHeaders currentPollHeader = new HttpHeaders();

        if (orderProduct.getProduct().getInventoryTotal() >= orderProduct.getCount()) {
            currentPollHeader.add("status", "1");
            currentPollHeader.add("message", "The purchase was successful");

            orderProductRepository.save(orderProduct);
            productRepository.setProductNewValues(orderProduct.getCount(), orderProduct.getProduct().getId());

            return new ResponseEntity<>(currentPollHeader, HttpStatus.CREATED);

        } else {
            currentPollHeader.add("status", "2");
            currentPollHeader.add("message", "There is not enough product stock");
            return new ResponseEntity<>(currentPollHeader, HttpStatus.OK);
        }

    }

    @Override
    public List<OrderProduct> getOrderProducts() {
        return orderProductRepository.findAll();
    }

}