package com.unmannedstore.features.shoppingmanagement.domain.service;

import com.unmannedstore.features.shoppingmanagement.domain.model.BasketItem;
import com.unmannedstore.features.shoppingmanagement.domain.model.Product;
import com.unmannedstore.features.shoppingmanagement.domain.model.RunningTotal;
import com.unmannedstore.features.shoppingmanagement.domain.model.ShoppingSession;
import com.unmannedstore.features.shoppingmanagement.domain.repository.ShoppingSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing shopping sessions and basket operations.
 */
@Service
public class ShoppingService {
    private final ShoppingSessionRepository sessionRepository;
    private final ProductService productService;
    private final PricingService pricingService;

    public ShoppingService(ShoppingSessionRepository sessionRepository, ProductService productService, PricingService pricingService) {
        this.sessionRepository = sessionRepository;
        this.productService = productService;
        this.pricingService = pricingService;
    }

    public Optional<ShoppingSession> getSession(Long customerId) {
        return sessionRepository.findByCustomerId(customerId);
    }

    public ShoppingSession getOrCreateSession(Long customerId) {
        return sessionRepository.findByCustomerId(customerId)
                .orElseGet(() -> sessionRepository.save(new ShoppingSession(customerId)));
    }

    public ShoppingSession addItem(Long customerId, Long productId, int quantity) {
        ShoppingSession session = getOrCreateSession(customerId);
        Optional<Product> productOpt = productService.getProductById(productId);
        if (productOpt.isEmpty()) throw new IllegalArgumentException("Product not found");
        Product product = productOpt.get();
        // Check if item already exists
        BasketItem item = session.getItems().stream()
                .filter(i -> i.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);
        if (item == null) {
            item = new BasketItem(product, quantity);
            session.getItems().add(item);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }
        // Update total
        session.setRunningTotal(pricingService.calculateTotal(session.getItems()));
        return sessionRepository.save(session);
    }

    public ShoppingSession removeItem(Long customerId, Long productId, int quantity) {
        ShoppingSession session = getOrCreateSession(customerId);
        BasketItem item = session.getItems().stream()
                .filter(i -> i.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);
        if (item != null) {
            int newQty = item.getQuantity() - quantity;
            if (newQty > 0) {
                item.setQuantity(newQty);
            } else {
                session.getItems().remove(item);
            }
            session.setRunningTotal(pricingService.calculateTotal(session.getItems()));
            sessionRepository.save(session);
        }
        return session;
    }

    public List<BasketItem> getBasketItems(Long customerId) {
        return getOrCreateSession(customerId).getItems();
    }

    public RunningTotal getRunningTotal(Long customerId) {
        return getOrCreateSession(customerId).getRunningTotal();
    }
} 