package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import com.example.util.ApiResponse;
import com.example.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<ProductDto> addProduct(ProductDto productDto) {
        Product product = convertToProduct(productDto);
        product = productRepository.save(product);
        return new ResponseEntity<>(convertToProductDTO(product), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDTOs = products.stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }
   
    @Override
    public ResponseEntity<ApiResponse<ProductDto>> getProductById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductDto productDto = convertToProductDTO(optionalProduct.get());
            return new ResponseEntity<>(new ApiResponse<>(true, productDto, "Product found.."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse<>(false, null, "Product not found.."), HttpStatus.NOT_FOUND);
        }
    }


 
    @Override
    public ResponseEntity<ApiResponse<ProductDto>> updateProduct(String id, ProductDto updatedProductDTO) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProductDTO.getName());
            existingProduct.setDescription(updatedProductDTO.getDescription());
            existingProduct.setPrice(updatedProductDTO.getPrice());
            existingProduct.setAvailability(updatedProductDTO.isAvailability());
            existingProduct = productRepository.save(existingProduct);
            return new ResponseEntity<>(new ApiResponse<>(true, convertToProductDTO(existingProduct), "Product updated.."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse<>(false, null, "Product not found.."), HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<String> deleteProductById(String id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ResponseEntity<>("Product deleted with ID: " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deleteAllProducts() {
        productRepository.deleteAll();
        return new ResponseEntity<>("All Records Deleted..", HttpStatus.OK);
    }

    private Product convertToProduct(ProductDto productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setAvailability(productDTO.isAvailability());
        return product;
    }

    private ProductDto convertToProductDTO(Product product) {
        ProductDto productDTO = new ProductDto();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setAvailability(product.isAvailability());
        return productDTO;
    }
}
