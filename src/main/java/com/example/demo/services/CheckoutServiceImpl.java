package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponseData;
import com.example.demo.entities.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;
/**
 * This class is used to place an order.
 */
@Service
public class CheckoutServiceImpl implements CheckoutService{

    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {

        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponseData placeOrder(Purchase purchase) {
        // retrieve the cart from the purchase
        Cart cart = purchase.getCart();

        // generate a random UUID number (UUID version-4)
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);

        // populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cart::add);


        cartRepository.save(cart);

        // Return a response
        return new PurchaseResponseData(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number
        return UUID.randomUUID().toString();
    }
}
