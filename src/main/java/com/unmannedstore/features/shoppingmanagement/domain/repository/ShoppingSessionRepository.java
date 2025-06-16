package com.unmannedstore.features.shoppingmanagement.domain.repository;

import com.unmannedstore.features.shoppingmanagement.domain.model.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for shopping sessions.
 */
public interface ShoppingSessionRepository extends JpaRepository<ShoppingSession, Long> {
    Optional<ShoppingSession> findByCustomerId(Long customerId);
} 