package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.CategoryDTO;
import com.example.LibraryManagementSystem.entity.Category;
import com.example.LibraryManagementSystem.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO dto) {
        return new ResponseEntity<>(service.createCategory(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAllCategories();
    }
}

