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


    public void setId(int id) {
    }

    public void setFirstName(String bob) {
    }

    public void setSurname(String beans) {
    }

    public void setAddress(String s) {
    }

    public void setPostcode(String s) {
    }

    public void setPhone(String number) {
    }

    public Integer getId() {
        return null;
    }

    public String getFirstName() {
        return null;
    }

    public String getSurname() {
        return null;
    }

    public String getAddress() {
        return null;
    }

    public String getPostcode() {
        return null;
    }

    public String getPhone() {
        return null;
    }
}
