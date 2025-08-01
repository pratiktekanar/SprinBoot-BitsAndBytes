package com.bitsnbytes.product.repository;
import java.util.Optional;


import com.bitsnbytes.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
