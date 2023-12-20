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
@Table(name = "countries")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String country_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;
    // 1 country to many divisions
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions = new HashSet<>();
}
/*
-- COUNTRIES Table
        CREATE TABLE COUNTRIES (
        Country_ID BIGINT PRIMARY KEY,
        Country_Name VARCHAR(255),
        Create_Date TIMESTAMP,
        Last_Update TIMESTAMP
        );*/
