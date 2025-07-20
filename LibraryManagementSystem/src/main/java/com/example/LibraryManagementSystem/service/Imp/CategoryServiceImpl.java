package com.example.LibraryManagementSystem.service.Imp;

import com.example.LibraryManagementSystem.Repositry.CategoryRepository;
import com.example.LibraryManagementSystem.dto.CategoryDTO;
import com.example.LibraryManagementSystem.entity.Category;
import com.example.LibraryManagementSystem.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public Category createCategory(CategoryDTO dto) {
        Category cat = new Category();
        cat.setName(dto.getName());

        if (dto.getParentId() != null) {
            Category parent = repo.findById(dto.getParentId()).orElseThrow();
            cat.setParent(parent);
        }

        return repo.save(cat);
    }

    @Override
    public List<Category> getAllCategories() {
        return repo.findAll();
    }
}

