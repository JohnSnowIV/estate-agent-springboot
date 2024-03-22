package com.estates.project.entities;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name="LISTED")
    private Boolean listed;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="POSTCODE")
    private String postcode;
    @Column(name="TYPE")
    private String type;
    @Column(name="PRICE")
    private Integer price;
    @Column(name="BEDROOM")
    private Integer bedroom;
    @Column(name="BATHROOM")
    private Integer bathroom;
    @Column(name="GARDEN")
    private Integer garden;
    @Column(name="SELLERID")
    private Integer sellerId;
    @Column(name="STATUS")
    private String status;
    @Column(name="IMAGE")
    private String image;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="DATEADDED")
    private LocalDateTime dateAdded;

    public Property(){

    }
    public Property(  Boolean listed,String address, String postcode, String type,
                    Integer price, Integer bedroom, Integer bathroom, Integer garden,
                    Integer sellerId, String status, String image, String description){


        this.address=address;
        this.listed=listed;
        this.postcode=postcode;
        this.type=type;
        this.price=price;
        this.bedroom=bedroom;
        this.bathroom=bathroom;
        this.garden=garden;
        this.sellerId=sellerId;
        this.status=status;
        this.image=image;
        this.description=description;

    }
    public Property(  Integer Id,Boolean listed,String address, String postcode, String type,
                      Integer price, Integer bedroom, Integer bathroom, Integer garden,
                      Integer sellerId, String status, String image, String description){

        this.Id=Id;
        this.address=address;
        this.listed=listed;
        this.postcode=postcode;
        this.type=type;
        this.price=price;
        this.bedroom=bedroom;
        this.bathroom=bathroom;
        this.garden=garden;
        this.sellerId=sellerId;
        this.status=status;
        this.image=image;
        this.description=description;

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

    public Integer getId() {
        return Id;
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

    public void setId(Integer propertyId) {
        this.Id = propertyId;
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
