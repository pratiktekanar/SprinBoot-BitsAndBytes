// File: service/ProductService.java
package com.bitsnbytes.product.service;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {

//    ProductRepository productRepository;

    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(@PathVariable long id);

    ProductDTO updateProduct(long id, ProductDTO productDTO);

    String deleteProductById(long id);

    String deleteProduct(Long id);

}
