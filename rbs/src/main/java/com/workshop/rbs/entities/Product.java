package com.workshop.rbs.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// JPA to specify this class correspond to a db table
@Entity
// lombok annot to create getters and setters and constructor
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // for auto-inc
    private Long id;
    private  String name;
    private double price;
    private int quantity;

}
