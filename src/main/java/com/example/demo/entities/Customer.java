package com.example.demo.entities;

//import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    // Constructor

    public Customer(String firstName, String lastName, String address, String postal_code, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;

    }
    // Default constructor
    public Customer() {
    }
    @Column(name = "customer_first_name", nullable=false) //Required field
    private String firstName;

    @Column(name = "customer_last_name", nullable=false) //Required field
    private String lastName;

    @Column(name = "address", nullable=false) //Required field
    private String address;

    @Column(name = "postal_code", nullable=false) //Required field
    private String postal_code;

    @Column(name = "phone", nullable=false) //Required field
    private String phone;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date Create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date Last_update;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "division_id")
    private Division division;
    //
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();
    //
    public void add(Cart cart) {
        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }
}
 /*CUSTOMERS Table
        CREATE TABLE CUSTOMERS (
        Customer_ID BIGINT PRIMARY KEY,
        First_Name VARCHAR(255),
        Last_Name VARCHAR(255),
        Address VARCHAR(255),
        City VARCHAR(255),
        Postal_Code VARCHAR(255),s
        Phone VARCHAR(255),
        Create_Date TIMESTAMP,
        Last_Update TIMESTAMP,
        Division_ID BIGINT FOREIGN KEY
        );*/