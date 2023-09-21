package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.service.ProductService;
import com.example.util.ApiResponse;
import com.example.dto.ProductDto;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
        ResponseEntity<ProductDto> responseEntity = productService.addProduct(productDto);
        return responseEntity;
    }

    @GetMapping("/findAllProducts")
    public ResponseEntity<List<ProductDto>> getProducts() {
        ResponseEntity<List<ProductDto>> responseEntity = productService.getAllProducts();
        return responseEntity; 
    }

    @GetMapping("/findProduct/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> getProduct(@PathVariable String id) {
        ResponseEntity<ApiResponse<ProductDto>> responseEntity = productService.getProductById(id);
        if (responseEntity.getBody() != null) {
            return responseEntity; 
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> modifyProduct(@PathVariable String id, @RequestBody ProductDto productDto) {
        try {
            ResponseEntity<ApiResponse<ProductDto>> responseEntity = productService.updateProduct(id, productDto);
            return responseEntity; 
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        ResponseEntity<String> responseEntity = productService.deleteProductById(id);
        if (responseEntity.getBody() != null) {
            return responseEntity; 
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllProducts() {
        ResponseEntity<String> responseEntity = productService.deleteAllProducts();
        return responseEntity; 
    }
}
