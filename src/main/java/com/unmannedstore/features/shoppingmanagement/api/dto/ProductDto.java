package com.unmannedstore.features.shoppingmanagement.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/**
 * DTO for product information in the shopping-management context.
 */
@Schema(description = "Product information in the shopping context")
public class ProductDto {
    @Schema(description = "Unique identifier of the product", example = "1")
    private Long productId;
    
    @Schema(description = "Name of the product", example = "Organic Bananas")
    private String name;
    
    @Schema(description = "Price of the product", example = "2.99")
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