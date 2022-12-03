package com.example.onlineshoptest1.controller;


import com.example.onlineshoptest1.domain.Product;
import com.example.onlineshoptest1.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    @Autowired
    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }


    @Override
    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    @Override
    public ResponseEntity<?> updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    @Override
    public List<Product> getProductsById(Long productId) {
        return productService.getProductsById(productId);
    }
}