package com.unmannedstore.features.shoppingmanagement.domain.service;

import com.unmannedstore.features.shoppingmanagement.domain.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void contextLoads() {
        assertThat(productService).isNotNull();
    }

    // Add more tests for getProductById, getAllProducts, etc.
} 