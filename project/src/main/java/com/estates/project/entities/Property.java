package com.estates.project.entities;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="property")
public class Property {

    @Id
    private Integer propertyId;
    private Boolean listed;
    private String address;
    private String postcode;
    private String type;
    private Integer price;
    private Integer bedroom;
    private Integer bathroom;
    private Integer garden;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="sellerId", referencedColumnName = "seller.sellerId")
    private Integer sellerId;
    private String status;
    private String image;
    private String description;
    private LocalDateTime dateAdded;

    public Property(){

    }

    public Boolean getListed() {
        return listed;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public Integer getGarden() {
        return garden;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGarden(Integer garden) {
        this.garden = garden;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setListed(Boolean listed) {
        this.listed = listed;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setType(String type) {
        this.type = type;
    }
}
