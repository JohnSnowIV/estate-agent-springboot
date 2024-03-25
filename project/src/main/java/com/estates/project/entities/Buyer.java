package com.estates.project.entities;

import jakarta.persistence.*;

@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name="SURNAME")
    private String surname;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="POSTCODE")
    private String postcode;
    @Column(name="PHONE")
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

    public Buyer(int id, String firstName, String surname, String address, String postcode, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return this.id;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public String getPhone() {
        return this.phone;
    }
}
