package com.bitsnbytes.product.controller;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.service.CategoryService;
import com.bitsnbytes.product.service.impl.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    //    Get category by id
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable long id){
        return categoryService.getCategoryById(id);
    }


    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

//    delete category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable long id){
        return categoryService.deleteCategory(id);

    }



}
