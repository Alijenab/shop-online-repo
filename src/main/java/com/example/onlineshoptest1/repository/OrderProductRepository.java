package com.example.onlineshoptest1.repository;


import com.example.onlineshoptest1.domain.Customer;
import com.example.onlineshoptest1.domain.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
