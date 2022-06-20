package com.security.SpringSecurityDemo.service.serviceImpl;

import com.security.SpringSecurityDemo.persistence.entity.Products;
import com.security.SpringSecurityDemo.persistence.repository.ProductRepository;
import com.security.SpringSecurityDemo.service.contract.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
}
