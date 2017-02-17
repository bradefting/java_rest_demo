package com.demoRestApi.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by chansehorton on 2/15/17.
 */

@Entity
@Table(name = "customers")
@SecondaryTable(name = "addresses", pkJoinColumns = @PrimaryKeyJoinColumn(name = "cust_id"))
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", table = "customers")
    @NotNull
    private String name;

    @Column(name = "email", table = "customers")
    @NotNull
    private String email;

    @Column(name = "phone", table = "customers")
    @NotNull
    private String phone;

    @Column(name = "street", table = "addresses")
    @NotNull
    private String street;

    @Column(name = "city", table = "addresses")
    @NotNull
    private String city;

    @Column(name = "state", table = "addresses")
    @NotNull
    private String state;

    @Column(name = "zip", table = "addresses")
    @NotNull
    private String zip;

    public Customer() { }

    public Customer(long id) {
        this.id = id;
    }

    public Customer(String name, String email, String phone, String street, String city, String state, String zip) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public long getId() { return id; }

    public void setID(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }

    public void setZip(String zip) { this.zip = zip; }

}
