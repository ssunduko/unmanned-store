package com.unmannedstore.features.shoppingmanagement.api.dto;

/**
 * DTO for requesting to add an item to the basket.
 */
public class ItemAddRequest {
    private Long productId;
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