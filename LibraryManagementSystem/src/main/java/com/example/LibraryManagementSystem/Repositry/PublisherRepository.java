package com.example.LibraryManagementSystem.Repositry;

import com.example.LibraryManagementSystem.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
