package com.estates.project.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Property {

    @Id
    private Integer propertyId;
}
