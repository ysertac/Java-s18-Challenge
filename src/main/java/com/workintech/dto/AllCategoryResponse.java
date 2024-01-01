package com.workintech.dto;

import com.workintech.entity.Category;

import java.util.List;

public record AllCategoryResponse(List<Category> categories) {
}
