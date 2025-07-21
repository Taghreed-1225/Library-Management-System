package com.example.LibraryManagementSystem.dto;

import com.example.LibraryManagementSystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;


    private String password;


    private String email;



    private Role role;



}
