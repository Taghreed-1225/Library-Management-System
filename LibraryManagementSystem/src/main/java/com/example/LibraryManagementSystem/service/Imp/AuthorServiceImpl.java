package com.example.LibraryManagementSystem.service.Imp;

import com.example.LibraryManagementSystem.Repositry.AuthorRepository;
import com.example.LibraryManagementSystem.dto.AuthorDTO;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repo;

    public AuthorServiceImpl(AuthorRepository repo) {
        this.repo = repo;
    }
    @Override
    public Author createAuthor(AuthorDTO dto) {
        Author author = new Author();
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());

        return repo.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return repo.findAll();
    }
}
