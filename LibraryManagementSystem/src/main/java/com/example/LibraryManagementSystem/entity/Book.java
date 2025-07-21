package com.example.LibraryManagementSystem.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private String language;
    private String edition;
    private String summary;
    private int publicationYear;
    private String coverImage;
    @Column(nullable = false)
    private boolean available;


    @ManyToMany
    @JsonManagedReference
    private List<Author> authors;

    @ManyToOne
    @JsonManagedReference
    private Publisher publisher;

    @ManyToOne
    @JsonManagedReference
    private Category category;
}
