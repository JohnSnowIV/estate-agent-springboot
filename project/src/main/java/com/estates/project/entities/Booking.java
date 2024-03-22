package com.estates.project.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id
    @Column(name = "id", nullable = false, updatable = true)
    private Integer bookingId;

    @Column(name = "Property-id", nullable = false, updatable = true)
    private Integer propertyId;
    @Column(name = "Buyer-id", nullable = false, updatable = true)
    private  Integer buyerId;

    @Column(name = "booking-date", nullable = false, updatable = true)
    private String dateTime;



    public Booking(){}//Empty Constructor

    public Booking(int propertyId, int buyerId, String dateTime){
        this.propertyId = propertyId;
        this.buyerId = buyerId;
        this.dateTime = dateTime;
    }




}
