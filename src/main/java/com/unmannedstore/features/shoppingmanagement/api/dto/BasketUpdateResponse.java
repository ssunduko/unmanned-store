package com.unmannedstore.features.shoppingmanagement.api.dto;

/**
 * DTO for returning the result of a basket update (add/remove item).
 */
public class BasketUpdateResponse {
    private boolean success;
    private String message;
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