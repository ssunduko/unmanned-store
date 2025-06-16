package com.unmannedstore.features.shoppingmanagement.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO for returning the result of a basket update (add/remove item).
 */
@Schema(description = "Response containing the result of a basket update operation")
public class BasketUpdateResponse {
    @Schema(description = "Whether the basket update operation was successful")
    private boolean success;
    
    @Schema(description = "Message describing the result of the operation")
    private String message;
    
    @Schema(description = "Updated contents of the basket after the operation")
    private BasketContentsResponse updatedBasket;

    public BasketUpdateResponse() {}

    public BasketUpdateResponse(boolean success, String message, BasketContentsResponse updatedBasket) {
        this.success = success;
        this.message = message;
        this.updatedBasket = updatedBasket;
    }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public BasketContentsResponse getUpdatedBasket() { return updatedBasket; }
    public void setUpdatedBasket(BasketContentsResponse updatedBasket) { this.updatedBasket = updatedBasket; }
} 