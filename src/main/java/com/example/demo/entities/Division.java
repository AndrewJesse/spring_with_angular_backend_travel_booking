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
@Table(name = "divisions")
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();

    @Column(name = "country_id")
    private long country_id;

    public Division(){
    }

    public Division(String division_name, Set<Customer> customers){
        this.division_name = division_name;
        this.customers = customers;
    }

    public void add(Customer customer) {
        if (customer != null) {
            if (customers == null) {
                customers = new HashSet<>();
            }
            customers.add(customer);
            customer.setDivision(this);
        }
    }
}


/*
 DIVISIONS Table
 CREATE TABLE DIVISIONS (
 Division_ID BIGINT PRIMARY KEY,
 Division_Name VARCHAR(255),
 Create_Date TIMESTAMP,
 Last_Update TIMESTAMP,
 Country_ID BIGINT FOREIGN KEY
 );*/
