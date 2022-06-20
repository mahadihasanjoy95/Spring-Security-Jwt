package com.security.SpringSecurityDemo.persistence.repository;

import com.security.SpringSecurityDemo.persistence.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, String> {
}
