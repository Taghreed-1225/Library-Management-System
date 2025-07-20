package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dto.CategoryDTO;
import com.example.LibraryManagementSystem.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO dto);
    List<Category> getAllCategories();
}

