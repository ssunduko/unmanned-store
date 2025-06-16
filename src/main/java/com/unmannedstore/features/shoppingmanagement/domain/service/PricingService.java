package com.unmannedstore.features.shoppingmanagement.domain.service;

import com.unmannedstore.features.shoppingmanagement.domain.model.BasketItem;
import com.unmannedstore.features.shoppingmanagement.domain.model.RunningTotal;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service for calculating pricing and running totals.
 */
@Service
public class PricingService {
    public RunningTotal calculateTotal(List<BasketItem> items) {
        BigDecimal total = items.stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new RunningTotal(total, "USD");
    }
} 