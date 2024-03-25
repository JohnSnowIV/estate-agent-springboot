package com.estates.project.entities;


import jakarta.persistence.*;

@Entity
//@Table(name="seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="SURNAME")
    private String surname;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="POSTCODE")
    private String postcode;
    @Column(name="PHONE")
    private String phone;


    public Seller(){

    }

    public Seller( String firstName, String surname, String address, String postcode, String phone){
        this.firstName= firstName;
        this.surname=surname;
        this.address=address;
        this.postcode=postcode;
        this.phone=phone;
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
