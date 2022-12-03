package com.example.onlineshoptest1.repository;


import com.example.onlineshoptest1.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllById(Long productId);

    @Modifying
    @Transactional(isolation = Isolation.READ_COMMITTED , rollbackFor = Exception.class , timeout = 30 , propagation = Propagation.NEVER)
    @Query("update Product p set p.inventoryTotal = p.inventoryTotal - ?1   where p.inventoryTotal >=?1  and p.id =?2")
    void setProductNewValues(int inventoryTotal, Long productId);

}