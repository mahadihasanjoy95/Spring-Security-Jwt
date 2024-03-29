package com.security.SpringSecurityDemo.rest;

import com.security.SpringSecurityDemo.dto.ApiResponse;
import com.security.SpringSecurityDemo.persistence.entity.Products;
import com.security.SpringSecurityDemo.persistence.repository.ProductRepository;
import com.security.SpringSecurityDemo.service.contract.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductCOntroller {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(path = "/create")
    public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody Products products) {
        Products product = productService.saveProduct(products);
        if (product == null) {
            return ResponseEntity.badRequest().body(new ApiResponse(BAD_REQUEST.value(), "Can't Create Product", product));
        } else return ResponseEntity.ok().body(new ApiResponse(OK.value(), "Product Created", product));
    }


    @RequestMapping(path = "/getAll")
    public ResponseEntity<ApiResponse> getProducts() {
        List<Products> products = productService.getAllProducts();
        if (products == null || products.size() == 0) {
            return ResponseEntity.badRequest().body(new ApiResponse(BAD_REQUEST.value(), "Can't fetch Products", products));
        } else return ResponseEntity.ok().body(new ApiResponse(OK.value(), "Product fetch successfully!", products));
    }

    @RequestMapping(path = "/deleteAll")
    public void deleteProducts() {
        productRepository.deleteAll();
    }

}
