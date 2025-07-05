// File: service/ProductService.java
package com.bitsnbytes.product.service;

import com.bitsnbytes.product.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
}