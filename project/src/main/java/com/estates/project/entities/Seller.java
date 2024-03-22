package com.estates.project.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Seller {

//    Test push
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="First_Name", nullable = false, updatable = true)
    private String firstName;
    @Column(name="Last_Name", nullable = false, updatable = true)
    private String surname;
    @Column(name="Address", nullable = false, updatable = true)
    private String address;
    @Column(name="PostCode", nullable = false, updatable = true)
    private String postcode;
    @Column(name="Phone_Number", nullable = false, updatable = true)
    private String phone;

    public Seller(){

    }
    public Seller(int id, String firstName, String surname, String address, String postcode, String phone){
        this.id= id;
        this.firstName= firstName;
        this.surname=surname;
        this.address=address;
        this.postcode=postcode;
        this.phone=phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
