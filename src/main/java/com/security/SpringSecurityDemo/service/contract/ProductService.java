package com.security.SpringSecurityDemo.service.contract;

import com.security.SpringSecurityDemo.persistence.entity.Products;

import java.util.List;

public interface ProductService {
    Products saveProduct(Products product);
    List<Products> getAllProducts();
}
