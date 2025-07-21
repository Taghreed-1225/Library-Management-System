package com.example.LibraryManagementSystem.service.Imp;

import com.example.LibraryManagementSystem.Repositry.AppUserRepository;
import com.example.LibraryManagementSystem.dto.UserDTO;
import com.example.LibraryManagementSystem.entity.AppUser;
import com.example.LibraryManagementSystem.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl {


    @Autowired
    private  AppUserRepository userRepository;
    @Autowired
    private  AppUserMapper userMapper;
    @Autowired
    private  PasswordEncoder passwordEncoder;



    public List<UserDTO> getAllUsers() {
        System.out.println("service user ");
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

    }

    public UserDTO createUser(UserDTO dto) {
        AppUser user = userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
