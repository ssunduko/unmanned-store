package com.unmannedstore.features.shoppingmanagement.api;

import com.unmannedstore.features.shoppingmanagement.api.dto.*;
import com.unmannedstore.features.shoppingmanagement.domain.model.BasketItem;
import com.unmannedstore.features.shoppingmanagement.domain.service.ShoppingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for shopping management (add/remove items, basket updates).
 */
@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {
    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @GetMapping("/basket")
    public ResponseEntity<BasketContentsResponse> getBasketContents(@RequestParam Long customerId) {
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

    @PostMapping("/basket/add")
    public ResponseEntity<BasketUpdateResponse> addItem(@RequestParam Long customerId, @RequestBody ItemAddRequest request) {
        try {
            shoppingService.addItem(customerId, request.getProductId(), request.getQuantity());
            BasketContentsResponse updated = getBasketContents(customerId).getBody();
            return ResponseEntity.ok(new BasketUpdateResponse(true, "Item added", updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BasketUpdateResponse(false, e.getMessage(), null));
        }
    }

    @PostMapping("/basket/remove")
    public ResponseEntity<BasketUpdateResponse> removeItem(@RequestParam Long customerId, @RequestBody ItemAddRequest request) {
        try {
            shoppingService.removeItem(customerId, request.getProductId(), request.getQuantity());
            BasketContentsResponse updated = getBasketContents(customerId).getBody();
            return ResponseEntity.ok(new BasketUpdateResponse(true, "Item removed", updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BasketUpdateResponse(false, e.getMessage(), null));
        }
    }
} 