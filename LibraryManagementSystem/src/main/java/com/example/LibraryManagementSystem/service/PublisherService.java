package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dto.PublisherDto;
import com.example.LibraryManagementSystem.entity.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher createPublisher(PublisherDto dto);
    List<Publisher> getAllPublishers();
}

