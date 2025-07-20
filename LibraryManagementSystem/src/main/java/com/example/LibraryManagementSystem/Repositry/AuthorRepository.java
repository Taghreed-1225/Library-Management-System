package com.example.LibraryManagementSystem.Repositry;

import com.example.LibraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
