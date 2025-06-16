package com.unmannedstore.features.shoppingmanagement.infrastructure.iot;

import org.springframework.stereotype.Service;

/**
 * Service for detecting items using IoT sensors (RFID, shelf sensors).
 */
@Service
public class ItemDetectionService {
    public void detectItem(String eventSource, String itemId) {
        // TODO: Integrate with IoT platform to detect item events
        System.out.println("Detected item " + itemId + " from source " + eventSource);
    }
} 