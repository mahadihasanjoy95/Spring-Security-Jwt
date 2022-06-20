package com.security.SpringSecurityDemo.rest;

import com.security.SpringSecurityDemo.dto.ApiResponse;
import com.security.SpringSecurityDemo.persistence.entity.Products;
import com.security.SpringSecurityDemo.service.contract.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/procuct")
public class ProductCOntroller {
    @Autowired
    ProductService productService;

    @PostMapping(path = "/create")
    public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody Products products) {
        Products product = productService.saveProduct(products);
        if (product == null) {return ResponseEntity.badRequest().body(new ApiResponse(BAD_REQUEST.value(),"Can't Create Product",product));}
        else return ResponseEntity.ok().body(new ApiResponse(OK.value(),"Product Created",product));
    }


    @PostMapping(path = "/getAll")
    public ResponseEntity<ApiResponse> getProducts() {
        List<Products> products = productService.getAllProducts();
        if (products==null || products.size()==0) {return ResponseEntity.badRequest().body(new ApiResponse(BAD_REQUEST.value(),"Can't fetch Products",products));}
        else return ResponseEntity.ok().body(new ApiResponse(OK.value(),"Product fetch successfully!",products));
    }

}
