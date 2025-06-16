package com.unmannedstore.features.shoppingmanagement.domain.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ShoppingServiceTest {
    @Mock
    private ProductService productService;
    @Mock
    private PricingService pricingService;
    @Mock
    private com.unmannedstore.features.shoppingmanagement.domain.repository.ShoppingSessionRepository sessionRepository;

    @InjectMocks
    private ShoppingService shoppingService;

    @Test
    void contextLoads() {
        assertThat(shoppingService).isNotNull();
    }

    // Add more tests for addItem, removeItem, etc.
} 