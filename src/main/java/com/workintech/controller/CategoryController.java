package com.workintech.controller;

import com.workintech.dto.AllCategoryResponse;
import com.workintech.dto.CategoryResponse;
import com.workintech.entity.Category;
import com.workintech.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponse save(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        return new CategoryResponse(savedCategory.getId(), savedCategory.getName());
    }

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable long id) {
        Category category = categoryService.findById(id);
        return new CategoryResponse(category.getId(), category.getName());
    }

}
