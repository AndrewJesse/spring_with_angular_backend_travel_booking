package com.example.demo.services;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponseData;

/**
 * This interface is used to place an order.
 */
public interface CheckoutService {
    /**
     * This method is used to place an order.
     * @param purchase Purchase
     * @return PurchaseResponseData PurchaseResponseData
     */
    PurchaseResponseData placeOrder(Purchase purchase);
}
