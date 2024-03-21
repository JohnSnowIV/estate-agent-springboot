package com.estates.project.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="seller")
public class Seller {

    @Id
    private Integer sellerId;
}
