package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dto.AuthorDTO;
import com.example.LibraryManagementSystem.entity.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(AuthorDTO dto);
    List<Author> getAllAuthors();

}
