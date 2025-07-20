package com.example.LibraryManagementSystem.service.Imp;

import com.example.LibraryManagementSystem.Repositry.BorrowingTransactionRepository;
import com.example.LibraryManagementSystem.dto.BorrowingTransactionDTO;
import com.example.LibraryManagementSystem.entity.BorrowingTransaction;
import com.example.LibraryManagementSystem.mapper.BorrowingTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingTransactionServiceImpl {
    @Autowired
    private  BorrowingTransactionRepository transactionRepo;
    @Autowired
    private  BorrowingTransactionMapper mapper;


    public List<BorrowingTransactionDTO> getAll() {
        return transactionRepo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public BorrowingTransactionDTO borrowBook(BorrowingTransactionDTO dto) {
        BorrowingTransaction tx = mapper.toEntity(dto);
        tx.setBorrowDate(LocalDate.now());
        tx.setReturned(false);
        return mapper.toDto(transactionRepo.save(tx));
    }

    public BorrowingTransactionDTO returnBook(Long id) {
        BorrowingTransaction tx = transactionRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        tx.setReturnDate(LocalDate.now());
        tx.setReturned(true);
        return mapper.toDto(transactionRepo.save(tx));
    }
}
