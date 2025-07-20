package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dto.BookDTO;
import com.example.LibraryManagementSystem.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(BookDTO dto);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, BookDTO dto);
    void deleteBook(Long id);
}
