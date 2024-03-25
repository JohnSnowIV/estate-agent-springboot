package com.estates.project.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "PROPERTYID")
    private Integer propertyId;
    @Column(name = "BUYERID")
    private  Integer buyerId;

    @Column(name = "TIME")
    private String dateTime;



    public Booking(){}//Empty Constructor

    public Booking(int propertyId, int buyerId, String dateTime){
        this.propertyId = propertyId;
        this.buyerId = buyerId;
        this.dateTime = dateTime;
    }


    public Booking(Integer bookingId, int propertyId, int buyerId, String dateTime){
        this.Id = bookingId;
        this.propertyId = propertyId;
        this.buyerId = buyerId;
        this.dateTime = dateTime;

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
