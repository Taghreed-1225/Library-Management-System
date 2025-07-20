package com.example.LibraryManagementSystem.mapper;

import com.example.LibraryManagementSystem.Repositry.AppUserRepository;
import com.example.LibraryManagementSystem.Repositry.BookRepository;
import com.example.LibraryManagementSystem.Repositry.MemberRepository;
import com.example.LibraryManagementSystem.dto.BorrowingTransactionDTO;
import com.example.LibraryManagementSystem.entity.BorrowingTransaction;
import org.springframework.stereotype.Component;

@Component
public class BorrowingTransactionMapper {

    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;
    private final AppUserRepository userRepo;

    public BorrowingTransactionMapper(BookRepository bookRepo, MemberRepository memberRepo, AppUserRepository userRepo) {
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
        this.userRepo = userRepo;
    }

    public BorrowingTransaction toEntity(BorrowingTransactionDTO dto) {
        BorrowingTransaction tx = new BorrowingTransaction();
        tx.setBorrowDate(dto.getBorrowDate());
        tx.setReturnDate(dto.getReturnDate());
        tx.setReturned(dto.isReturned());

        tx.setBook(bookRepo.findById(dto.getBookId()).orElseThrow());
        tx.setMember(memberRepo.findById(dto.getMemberId()).orElseThrow());
        tx.setUser(userRepo.findById(dto.getUserId()).orElseThrow());

        return tx;
    }

    public BorrowingTransactionDTO toDto(BorrowingTransaction tx) {
        return new BorrowingTransactionDTO(
                tx.getId(),
                tx.getBook().getId(),
                tx.getMember().getId(),
                tx.getUser().getId(),
                tx.getBorrowDate(),
                tx.getReturnDate(),
                tx.isReturned()
        );
    }
}

