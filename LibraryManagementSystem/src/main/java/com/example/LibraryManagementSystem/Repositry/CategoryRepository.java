package com.example.LibraryManagementSystem.Repositry;

import com.example.LibraryManagementSystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
