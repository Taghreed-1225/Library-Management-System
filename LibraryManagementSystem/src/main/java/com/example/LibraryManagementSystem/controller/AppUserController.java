package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.UserDTO;
import com.example.LibraryManagementSystem.service.Imp.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

     @Autowired
    private AppUserServiceImpl userService;



    @GetMapping

    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO dto) {
        return userService.createUser(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

