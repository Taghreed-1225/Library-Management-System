package com.example.LibraryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingTransactionDTO {
    private Long id;
    private Long bookId;
    private Long memberId;
    private Long userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean returned;
}

