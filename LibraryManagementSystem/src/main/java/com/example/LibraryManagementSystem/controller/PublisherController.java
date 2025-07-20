package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.PublisherDto;
import com.example.LibraryManagementSystem.entity.Publisher;
import com.example.LibraryManagementSystem.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Publisher> create(@RequestBody PublisherDto dto) {
        return new ResponseEntity<>(service.createPublisher(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Publisher> getAll() {
        return service.getAllPublishers();
    }
}

