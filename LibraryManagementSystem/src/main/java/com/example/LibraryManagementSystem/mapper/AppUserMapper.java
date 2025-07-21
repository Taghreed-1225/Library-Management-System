package com.example.LibraryManagementSystem.mapper;

import com.example.LibraryManagementSystem.dto.UserDTO;
import com.example.LibraryManagementSystem.entity.AppUser;
import com.example.LibraryManagementSystem.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class AppUserMapper {
    public AppUser toEntity(UserDTO dto) {
        AppUser user = new AppUser();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // هنتكلم في التشفير كمان شوية
        user.setRole(Role.valueOf(String.valueOf(dto.getRole())));
        return user;
    }

    public UserDTO toDto(AppUser user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }
}

