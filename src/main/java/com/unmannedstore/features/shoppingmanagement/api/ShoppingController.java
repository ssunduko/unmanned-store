package com.unmannedstore.features.shoppingmanagement.api;

import com.unmannedstore.features.shoppingmanagement.api.dto.*;
import com.unmannedstore.features.shoppingmanagement.domain.model.BasketItem;
import com.unmannedstore.features.shoppingmanagement.domain.service.ShoppingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for shopping management (add/remove items, basket updates).
 */
@RestController
@RequestMapping("/api/shopping")
@Tag(name = "Shopping Management", description = "APIs for managing shopping baskets and items")
public class ShoppingController {
    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @Operation(summary = "Get basket contents", description = "Retrieves the current contents of a customer's shopping basket")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Basket contents retrieved successfully",
                    content = @Content(schema = @Schema(implementation = BasketContentsResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid customer ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping("/basket")
    public ResponseEntity<BasketContentsResponse> getBasketContents(
            @Parameter(description = "ID of the customer whose basket to retrieve", required = true)
            @RequestParam Long customerId) {
        List<BasketItem> items = shoppingService.getBasketItems(customerId);
        BasketContentsResponse response = new BasketContentsResponse(
                items.stream().map(item -> new ProductDto(
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getProduct().getPrice()
                )).collect(Collectors.toList()),
                items.stream().mapToInt(BasketItem::getQuantity).sum(),
                shoppingService.getRunningTotal(customerId).getTotalAmount()
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Add item to basket", description = "Adds a specified quantity of an item to the customer's basket")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Item added successfully",
                    content = @Content(schema = @Schema(implementation = BasketUpdateResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid request parameters or product not found"),
        @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @PostMapping("/basket/add")
    public ResponseEntity<BasketUpdateResponse> addItem(
            @Parameter(description = "ID of the customer whose basket to update", required = true)
            @RequestParam Long customerId,
            @Parameter(description = "Item details to add to the basket", required = true)
            @RequestBody ItemAddRequest request) {
        try {
            shoppingService.addItem(customerId, request.getProductId(), request.getQuantity());
            BasketContentsResponse updated = getBasketContents(customerId).getBody();
            return ResponseEntity.ok(new BasketUpdateResponse(true, "Item added", updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BasketUpdateResponse(false, e.getMessage(), null));
        }
    }

    @Operation(summary = "Remove item from basket", description = "Removes a specified quantity of an item from the customer's basket")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Item removed successfully",
                    content = @Content(schema = @Schema(implementation = BasketUpdateResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid request parameters or item not in basket"),
        @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @PostMapping("/basket/remove")
    public ResponseEntity<BasketUpdateResponse> removeItem(
            @Parameter(description = "ID of the customer whose basket to update", required = true)
            @RequestParam Long customerId,
            @Parameter(description = "Item details to remove from the basket", required = true)
            @RequestBody ItemAddRequest request) {
        try {
            shoppingService.removeItem(customerId, request.getProductId(), request.getQuantity());
            BasketContentsResponse updated = getBasketContents(customerId).getBody();
            return ResponseEntity.ok(new BasketUpdateResponse(true, "Item removed", updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BasketUpdateResponse(false, e.getMessage(), null));
        }
    }
} 