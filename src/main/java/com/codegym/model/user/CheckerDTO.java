package com.codegym.model.user;

import com.codegym.model.account.Account;

import javax.persistence.*;

public class CheckerDTO {

    private String id;
    private String account_id;
    private String name;
    private String dob;
    private String gender;
    private String identity;
    private String address;
    private String city;
    private String hobbies;
    private String description;
    private String url_facebook;

    public CheckerDTO() {
    }

    public CheckerDTO(String id, String account_id, String name, String dob, String gender, String identity, String address, String city, String hobbies, String description, String url_facebook) {
        this.id = id;
        this.account_id = account_id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.identity = identity;
        this.address = address;
        this.city = city;
        this.hobbies = hobbies;
        this.description = description;
        this.url_facebook = url_facebook;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_facebook() {
        return url_facebook;
    }

    public void setUrl_facebook(String url_facebook) {
        this.url_facebook = url_facebook;
    }
}
