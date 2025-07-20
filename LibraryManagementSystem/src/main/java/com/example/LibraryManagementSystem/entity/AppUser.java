package com.example.LibraryManagementSystem.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // setters + getters + toString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // ADMIN, LIBRARIAN, STAFF

   @OneToMany(mappedBy = "user")
    private List<BorrowingTransaction> handledTransactions;

}
