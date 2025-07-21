package com.example.LibraryManagementSystem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/public")
    public String publicTest() {
        return "✅ Public endpoint works";
    }

    @GetMapping("/authenticated")
    public String authTest() {
        return "✅ You are authenticated!";
    }

    @GetMapping("/admin")
    public String adminTest() {
        return "✅ You are ADMIN!";
    }
}

