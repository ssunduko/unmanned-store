package com.unmannedstore.features.shoppingmanagement.domain.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain model for a shopping session.
 */
@Entity
public class ShoppingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BasketItem> items = new ArrayList<>();

    @Embedded
    private RunningTotal runningTotal;

    public ShoppingSession() {}

    public ShoppingSession(Long customerId) {
        this.customerId = customerId;
        this.runningTotal = new RunningTotal();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public List<BasketItem> getItems() { return items; }
    public void setItems(List<BasketItem> items) { this.items = items; }

    public RunningTotal getRunningTotal() { return runningTotal; }
    public void setRunningTotal(RunningTotal runningTotal) { this.runningTotal = runningTotal; }
} 