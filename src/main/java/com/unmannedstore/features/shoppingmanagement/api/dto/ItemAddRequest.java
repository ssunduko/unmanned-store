package com.unmannedstore.features.shoppingmanagement.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for requesting to add an item to the basket.
 */
@Schema(description = "Request to add or remove an item from the basket")
public class ItemAddRequest {
    @Schema(description = "ID of the product to add or remove", example = "1")
    private Long productId;
    
    @Schema(description = "Quantity of the product to add or remove", example = "1", minimum = "1")
    private int quantity;

    public ItemAddRequest() {}

    public ItemAddRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
} 