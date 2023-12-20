package com.example.demo.controllers;

import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponseData;
import com.example.demo.services.CheckoutService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is used to handle checkout requests.
 * Spring RestController, which means it is capable of handling HTTP requests and sending HTTP responses.
 */
@RestController
@RequestMapping("/api/checkout")
@CrossOrigin(origins = "http://localhost:4200")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    /**
     * This method is used to place an order.
     * @param purchase PurchaseData
     * @return ResponseEntity<PurchaseResponseData>
     */
    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponseData> placeOrder(@Valid @RequestBody Purchase purchase) {
        return ResponseEntity.ok(checkoutService.placeOrder(purchase));
    }
}
