package com.example.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private String email;

    private String phone;
    private String address;

    private LocalDate registrationDate;

    @OneToMany(mappedBy = "member")
    private List<BorrowingTransaction> borrowingTransactions;

}
