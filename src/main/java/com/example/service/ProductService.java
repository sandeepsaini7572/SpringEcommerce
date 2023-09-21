package com.example.service;

import com.example.dto.ProductDto;
import com.example.util.ApiResponse;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<ProductDto> addProduct(ProductDto productDto);
    ResponseEntity<List<ProductDto>> getAllProducts();
    ResponseEntity<ApiResponse<ProductDto>> getProductById(String id);
    ResponseEntity<ApiResponse<ProductDto>> updateProduct(String id, ProductDto updatedProductDto);
    ResponseEntity<String> deleteProductById(String id);
    ResponseEntity<String> deleteAllProducts();
}

