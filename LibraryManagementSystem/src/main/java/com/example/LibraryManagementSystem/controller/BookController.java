package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.BookDTO;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody BookDTO dto) {
        return new ResponseEntity<>(service.createBook(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Book> getAll() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody BookDTO dto) {
        return service.updateBook(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
