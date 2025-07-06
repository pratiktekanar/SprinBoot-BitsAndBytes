package com.bitsnbytes.product.service;

import com.bitsnbytes.product.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(long id);
//    CategoryDTO deleteCategory(long id);
    String deleteCategory(long id);

}
