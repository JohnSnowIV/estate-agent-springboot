package com.estates.project.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Seller {

//    Test push
    @Id
//    @GeneratedValue
    private Integer sellerId;

    private String sellerFirstName;
    private String sellerLastName;
    private String sellerAddress;
    private String sellerPostcode;
    private String sellerPhone;


}
