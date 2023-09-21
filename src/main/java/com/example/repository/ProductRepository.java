package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	Optional<Product> findById(int id);
    // Additional custom queries can be defined here if needed

	void deleteById(int id);
}
