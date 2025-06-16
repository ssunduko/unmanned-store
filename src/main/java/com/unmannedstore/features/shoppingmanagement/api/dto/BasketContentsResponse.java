package com.unmannedstore.features.shoppingmanagement.api.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for returning the contents of a shopping basket.
 */
public class BasketContentsResponse {
    private List<ProductDto> items;
    private int totalItems;
    private BigDecimal totalAmount;

    public BasketContentsResponse() {}

    public BasketContentsResponse(List<ProductDto> items, int totalItems, BigDecimal totalAmount) {
        this.items = items;
        this.totalItems = totalItems;
        this.totalAmount = totalAmount;
    }

    public List<ProductDto> getItems() { return items; }
    public void setItems(List<ProductDto> items) { this.items = items; }

    public int getTotalItems() { return totalItems; }
    public void setTotalItems(int totalItems) { this.totalItems = totalItems; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
} 