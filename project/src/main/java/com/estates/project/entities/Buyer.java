package com.estates.project.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Buyer {

    @Id
    private Integer buyerId;
    private String firstName;
}
