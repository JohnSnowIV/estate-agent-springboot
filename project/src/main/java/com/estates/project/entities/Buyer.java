package com.estates.project.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.AutoConfiguration;

@Entity
public class Buyer {

    @Id
    private Integer buyerId;
    @Column(name = "first_name", nullable = false, updatable = true)
    private String firstName;
    @Column(name="last_name", nullable = false, updatable = true)
    private String surname;
    @Column(name="address", nullable = false, updatable = true)
    private String address;
    @Column(name="postcode", nullable = false, updatable = true)
    private String postcode;
    @Column(name="phone", nullable = false, updatable = true)
    private String phone;

    public Buyer() {
        // Empty Constructor
    }

    public Buyer(String firstName, String surname, String address, String postcode, String phone) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
    }

    public Buyer(Integer buyerId, String firstName, String surname, String address, String postcode, String phone) {
        this.buyerId = buyerId;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
    }

    public void setId(int id) {
        this.buyerId = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPhone(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public Integer getId() {
        return buyerId;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhone() {
        return phone;
    }
}
