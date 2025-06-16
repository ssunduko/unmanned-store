package com.unmannedstore.features.shoppingmanagement.api.dto;

import java.math.BigDecimal;

/**
 * DTO for product information in the shopping-management context.
 */
public class ProductDto {
    private Long productId;
    private String name;
    private BigDecimal price;

    public ProductDto() {}

    public ProductDto(Long productId, String name, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
} 