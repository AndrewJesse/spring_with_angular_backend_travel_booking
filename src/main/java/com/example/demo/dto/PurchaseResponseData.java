package com.example.demo.dto;

import lombok.Data;

/**
 * A purchase response data class that contains an order tracking number
 * that will be sent back to the client
 * */
@Data
public class PurchaseResponseData {
    private String orderTrackingNumber;

    public PurchaseResponseData(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
