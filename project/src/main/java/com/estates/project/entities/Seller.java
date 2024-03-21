package com.estates.project.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Seller {

//    Test push
    @Id
//    @GeneratedValue
    private Integer sellerId;

    @Column(name="First_Name", nullable = false, updatable = true)
    private String sellerFirstName;
    @Column(name="Last_Name", nullable = false, updatable = true)
    private String sellerLastName;
    @Column(name="Address", nullable = false, updatable = true)
    private String sellerAddress;
    @Column(name="PostCode", nullable = false, updatable = true)
    private String sellerPostcode;
    @Column(name="Phone_Number", nullable = false, updatable = true)
    private String sellerPhone;


}
