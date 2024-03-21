package com.estates.project.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Seller {

    @Id
    private Integer sellerId;
}
