package com.example.LibraryManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private String isbn;
    private String language;
    private String edition;
    private String summary;
    private int publicationYear;
    private String coverImage;
    private List<Long> authorIds;
    private Long publisherId;
    private Long categoryId;




}
