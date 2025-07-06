// File: controller/ProductController.java
package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

//  Create product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createProduct , HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable long id){
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable long id){
        return productService.deleteProductById(id);
    }
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable long id ,@RequestBody ProductDTO productDTO){
        return productService.updateProduct(id,productDTO);
    }
}