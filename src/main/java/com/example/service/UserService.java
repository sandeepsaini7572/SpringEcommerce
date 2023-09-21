package com.example.service;

import org.springframework.http.ResponseEntity;

import com.example.dto.UserDto;
import com.example.model.User;

public interface UserService {
    ResponseEntity<String> registerUser(UserDto userDto);
    User findUserByEmail(String email);
    ResponseEntity<String> login(UserDto userDto);

}