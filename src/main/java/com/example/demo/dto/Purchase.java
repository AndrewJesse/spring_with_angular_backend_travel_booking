package com.example.demo.dto;

import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import lombok.Data;

import java.util.Set;

/**
 * This class is used to transfer data from the CartController to the CartService.
 */
@Data

public class Purchase {
    private Customer customer;
    //@NotNull(message = "PurchaseData must have a cart")
    private Cart cart;

    //@Size(min = 1, message = "PurchaseData must have at least one cart item")
    private Set<CartItem> cartItems;

}
