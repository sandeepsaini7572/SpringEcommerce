package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }
    
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        ResponseEntity<String> registeredUser = userService.registerUser(userDto);
        return registeredUser; // Return the ResponseEntity directly
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        ResponseEntity<String> authenticatedUser = userService.login(userDto);
        return authenticatedUser; // Return the ResponseEntity directly
    }
}

