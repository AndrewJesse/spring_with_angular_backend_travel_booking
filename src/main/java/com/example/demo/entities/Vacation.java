package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VACATIONS")
@Getter
@Setter
public class Vacation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "vacation_id")
        private int id;

        @Column(name = "vacation_title")
        private String vacation_title;

        @Column(name = "description")
        private String description;

        @Column(name = "travel_fare_price")
        private Double travel_price;

        @Column(name = "image_URL")
        private String image_URL;

        @CreationTimestamp
        @Column(name = "create_date")
        private Date create_date;

        @UpdateTimestamp
        @Column(name = "last_update")
        private Date last_update;

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
        private Set<CartItem> cartItems = new HashSet<>();

        @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
        private Set<Excursion> excursions = new HashSet<>();
}
/*
-- VACATIONS Table
        CREATE TABLE VACATIONS (
        Vacation_ID BIGINT PRIMARY KEY,
        Vacation_Title VARCHAR(255),
        Description VARCHAR(255),
        Travel_Fare_Price DOUBLE(10),
        Image_URL VARCHAR(255),
        Create_Date TIMESTAMP,
        Last_Update TIMESTAMP
        );

        Vacation
        - id: Long
        - vacation_title: String
        - description: String
        - travel_price: BigDecimal
        - image_URL: String
        - create_date: Date
        - last_update: Date
        - excursions: Set<Excursion>
+ Vacation()*/
