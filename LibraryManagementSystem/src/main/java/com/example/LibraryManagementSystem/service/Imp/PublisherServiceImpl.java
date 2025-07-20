package com.example.LibraryManagementSystem.service.Imp;

import com.example.LibraryManagementSystem.Repositry.PublisherRepository;
import com.example.LibraryManagementSystem.dto.PublisherDto;
import com.example.LibraryManagementSystem.entity.Publisher;
import com.example.LibraryManagementSystem.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository repo;

    public PublisherServiceImpl(PublisherRepository repo) {
        this.repo = repo;
    }

    @Override
    public Publisher createPublisher(PublisherDto dto) {
        Publisher pub = new Publisher();
        pub.setName(dto.getName());
        pub.setAddress(dto.getAddress());
        return repo.save(pub);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return repo.findAll();
    }
}

