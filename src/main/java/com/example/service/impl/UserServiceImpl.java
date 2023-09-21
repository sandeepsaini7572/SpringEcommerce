package com.example.service.impl;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;

import com.example.exception.EmailAlreadyExistsException;
import com.example.exception.UserNotFoundException;
import com.example.exception.InvalidPasswordException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder; // Inject PasswordEncoder
    
    @Override
    public ResponseEntity<String> registerUser(UserDto userDto) {
        // Check if the user with the given email already exists
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new EmailAlreadyExistsException("Email already exists..");
        }

        // Create a new user
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setEmail(userDto.getEmail());
        // Hash the password
        String hashedPassword = passwordEncoder.encode(userDto.getPassword()); // Hash the password
        user.setPassword(hashedPassword);

        // Save the user to the database
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully..");
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public ResponseEntity<String> login(UserDto userDto) {
        // Find the user by email
        User user = userRepository.findByEmail(userDto.getEmail());

        if (user == null) {
            throw new UserNotFoundException("User not found..");
        }

        // Check if the provided password matches the user's stored password
        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException("Invalid password..");
        }

        // Return the authenticated user
        return ResponseEntity.ok("User logged in successfully..");
    }
}
