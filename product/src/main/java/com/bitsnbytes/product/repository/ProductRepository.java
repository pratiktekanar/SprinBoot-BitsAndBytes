// File: repository/ProductRepository.java
package com.bitsnbytes.product.repository;

import com.bitsnbytes.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}