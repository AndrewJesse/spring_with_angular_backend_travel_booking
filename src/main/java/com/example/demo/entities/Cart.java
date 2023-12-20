package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CARTS")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Cart_ID")
    private Long id;

    @Column (name = "Package_Price")
    private Double packagePrice;

    @Column (name = "Party_Size")
    private Integer partySize;

    @Enumerated(EnumType.STRING)
    @Column (name = "Status")
    private StatusType status;

    @Column (name = "Order_Tracking_Number")
    private String orderTrackingNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "Create_Date")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "Last_Update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "Customer_ID")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    public void add(CartItem item){
        if (item!= null) {
            if (cartItems == null) {
                cartItems = new HashSet<>();
            }

            cartItems.add(item);
            item.setCart(this);
        }
    }
}


/*
-- CARTS Table
        CREATE TABLE CARTS (
        Cart_ID BIGINT PRIMARY KEY,
        Package_Price DOUBLE(10),
        Party_Size INT(10),
        Status STATUSTYPE,
        Order_Tracking_Number VARCHAR(255),
        Create_Date TIMESTAMP,
        Last_Update TIMESTAMP,
        Customer_ID BIGINT FOREIGN KEY
        );*/
