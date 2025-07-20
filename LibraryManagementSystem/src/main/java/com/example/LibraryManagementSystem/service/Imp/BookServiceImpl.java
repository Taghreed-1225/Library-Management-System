package com.example.LibraryManagementSystem.service.Imp;

import com.example.LibraryManagementSystem.Repositry.AuthorRepository;
import com.example.LibraryManagementSystem.Repositry.BookRepository;
import com.example.LibraryManagementSystem.Repositry.CategoryRepository;
import com.example.LibraryManagementSystem.Repositry.PublisherRepository;
import com.example.LibraryManagementSystem.dto.BookDTO;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Category;
import com.example.LibraryManagementSystem.entity.Publisher;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl  implements BookService {

    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private AuthorRepository authorRepo;
    @Autowired
    private PublisherRepository publisherRepo;
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public Book createBook(BookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setLanguage(dto.getLanguage());
        book.setEdition(dto.getEdition());
        book.setSummary(dto.getSummary());
        book.setPublicationYear(dto.getPublicationYear());
        book.setCoverImage(dto.getCoverImage());

        List<Author> authors = authorRepo.findAllById(dto.getAuthorIds());
        Publisher publisher = publisherRepo.findById(dto.getPublisherId()).orElseThrow();
        Category category = categoryRepo.findById(dto.getCategoryId()).orElseThrow();

        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setCategory(category);

        return bookRepo.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElseThrow();
    }

    @Override
    public Book updateBook(Long id, BookDTO dto) {
        Book book = getBookById(id);
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setLanguage(dto.getLanguage());
        book.setEdition(dto.getEdition());
        book.setSummary(dto.getSummary());
        book.setPublicationYear(dto.getPublicationYear());
        book.setCoverImage(dto.getCoverImage());

        List<Author> authors = authorRepo.findAllById(dto.getAuthorIds());
        Publisher publisher = publisherRepo.findById(dto.getPublisherId()).orElseThrow();
        Category category = categoryRepo.findById(dto.getCategoryId()).orElseThrow();

        book.setAuthors(authors);
        book.setPublisher(publisher);
        book.setCategory(category);

        return bookRepo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
