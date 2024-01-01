package com.workintech.repository;

import com.workintech.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT c.id, c.name FROM s18c.category as c",
            nativeQuery = true)
    List<Category> getAllCategories();
}
