package com.unmannedstore.features.shoppingmanagement.infrastructure.iot;

import org.springframework.stereotype.Service;

/**
 * Processes RFID events for item detection in the store.
 */
@Service
public class RFIDEventProcessor {
    public void processRfidEvent(String rfidTag) {
        // TODO: Integrate with IoT platform to process RFID tag events
        System.out.println("Processing RFID tag: " + rfidTag);
    }
} 