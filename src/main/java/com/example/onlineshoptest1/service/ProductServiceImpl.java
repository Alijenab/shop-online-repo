package com.example.onlineshoptest1.service;

import com.example.onlineshoptest1.domain.Product;
import com.example.onlineshoptest1.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }


    @Override
    public ResponseEntity<?> updateProduct(Product product) {
        Optional<Product> productOpt = productRepository.findById(product.getId());
        if (productOpt.isPresent()) {

            productOpt.get().setName(product.getName());
            productOpt.get().setPrice(product.getPrice());
            productOpt.get().setInventoryTotal(product.getInventoryTotal());

            return new ResponseEntity<>(productRepository.save(productOpt.get()), null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public List<Product> getProductsById(Long productId) {
        return productRepository.findAllById(productId);
    }
}