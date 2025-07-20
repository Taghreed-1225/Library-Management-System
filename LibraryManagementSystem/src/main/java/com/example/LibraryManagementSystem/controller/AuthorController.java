package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.AuthorDTO;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody AuthorDTO dto) {
        return new ResponseEntity<>(service.createAuthor(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Author> getAll() {
        return service.getAllAuthors();
    }
}

