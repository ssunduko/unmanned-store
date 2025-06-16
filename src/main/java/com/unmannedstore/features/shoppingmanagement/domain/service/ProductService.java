package com.unmannedstore.features.shoppingmanagement.domain.service;

import com.unmannedstore.features.shoppingmanagement.domain.model.Product;
import com.unmannedstore.features.shoppingmanagement.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for product-related operations.
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // TODO: Implement product lookup, etc.
} 