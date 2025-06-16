package com.unmannedstore.features.shoppingmanagement.domain.model;

import java.math.BigDecimal;

/**
 * Domain model for the running total of a shopping session.
 */
public class RunningTotal {
    private BigDecimal totalAmount;
    private String currency;

    public RunningTotal() {}

    public RunningTotal(BigDecimal totalAmount, String currency) {
        this.totalAmount = totalAmount;
        this.currency = currency;
    }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
} 