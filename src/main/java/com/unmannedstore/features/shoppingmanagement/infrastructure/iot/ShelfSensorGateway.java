package com.unmannedstore.features.shoppingmanagement.infrastructure.iot;

import org.springframework.stereotype.Service;

/**
 * Gateway for shelf sensors (detects product removal/addition).
 */
@Service
public class ShelfSensorGateway {
    public void processShelfSensorEvent(String sensorId, boolean itemRemoved) {
        // TODO: Integrate with IoT platform to process shelf sensor events
        System.out.println("Shelf sensor " + sensorId + " itemRemoved=" + itemRemoved);
    }
} 