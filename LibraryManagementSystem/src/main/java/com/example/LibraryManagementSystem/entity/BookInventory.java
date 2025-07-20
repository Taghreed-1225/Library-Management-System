package com.example.LibraryManagementSystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_inventory")
public class BookInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Integer totalCopies;
    private Integer availableCopies;
    private Integer borrowedCopies;

    public void borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            borrowedCopies++;
        }
    }

    public void returnBook() {
        if (borrowedCopies > 0) {
            borrowedCopies--;
            availableCopies++;
        }
    }
}
