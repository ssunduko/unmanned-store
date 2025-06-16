package com.unmannedstore.features.shoppingmanagement.domain.repository;

import com.unmannedstore.features.shoppingmanagement.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing products.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Additional query methods if needed
} 