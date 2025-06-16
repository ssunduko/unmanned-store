package com.unmannedstore.features.shoppingmanagement.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for returning the contents of a shopping basket.
 */
@Schema(description = "Response containing the contents of a shopping basket")
public class BasketContentsResponse {
    @Schema(description = "List of products in the basket with their details")
    private List<ProductDto> items;
    
    @Schema(description = "Total number of items in the basket")
    private int totalItems;
    
    @Schema(description = "Total monetary amount for all items in the basket")
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