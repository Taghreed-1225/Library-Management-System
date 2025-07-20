package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.BorrowingTransactionDTO;
import com.example.LibraryManagementSystem.service.Imp.BorrowingTransactionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class BorrowingTransactionController {

    private final BorrowingTransactionServiceImpl service;

    public BorrowingTransactionController(BorrowingTransactionServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<BorrowingTransactionDTO> getAll() {
        return service.getAll();
    }

    @PostMapping("/borrow")
    public BorrowingTransactionDTO borrow(@RequestBody BorrowingTransactionDTO dto) {
        return service.borrowBook(dto);
    }

    @PutMapping("/return/{id}")
    public BorrowingTransactionDTO returnBook(@PathVariable Long id) {
        return service.returnBook(id);
    }
}
