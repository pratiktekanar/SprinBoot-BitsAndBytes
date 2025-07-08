// File: service/impl/ProductServiceImpl.java
package com.bitsnbytes.product.service.impl;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.entity.Product;
import com.bitsnbytes.product.exception.CategoryNotFoundException;
import com.bitsnbytes.product.mapper.ProductMapper;
import com.bitsnbytes.product.repository.CategoryRepository;
import com.bitsnbytes.product.repository.ProductRepository;
import com.bitsnbytes.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category "+productDTO.getCategoryId()+" not found"));

        Product product = ProductMapper.toProductEntity(productDTO, category);
        return ProductMapper.toProductDTO(productRepository.save(product));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toProductDTO)
                .collect(Collectors.toList());
    }
//    Get product By ID
    @Override
    public ProductDTO getProductById(long id){
       Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product Not Find"));
       return ProductMapper.toProductDTO(product);

    }

//    Update product
    @Override
    public ProductDTO updateProduct(long id, ProductDTO productDTO){
        Product product = productRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("product not found"));
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()->new RuntimeException("product not found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }
//    delete by id
    @Override
    public String deleteProductById(long id){
        productRepository.deleteById(id);
        return "Delete Product "+id;
    }

    @Override
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product "+ id + " has been deleted!";
    }

}
