package com.codegym.model.user;

import com.codegym.model.account.Account;
import com.codegym.model.receipt.Bill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "checkers")
public class Checker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Account account;

    private String name;
    private String dob;
    @ManyToOne(targetEntity = Gender.class)
    private Gender gender;
    private String identity;
    private String address;
    private String city;
    private String hobbies;
    private String description;
    private String url_facebook;

    @OneToMany(targetEntity = Bill.class, mappedBy = "checker")
    @JsonBackReference
    private List<Bill> billList;


    public Checker() {
    }

    public Checker(Account account, String name, String dob, Gender gender, String identity, String address, String city, String hobbies, String description, String url_facebook, List<Bill> billList) {
        this.account = account;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.identity = identity;
        this.address = address;
        this.city = city;
        this.hobbies = hobbies;
        this.description = description;
        this.url_facebook = url_facebook;
        this.billList = billList;
    }

    public Checker(String name, String dob, Gender gender, String identity, String address, String city, String hobbies, String description, String url_facebook, List<Bill> billList) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.identity = identity;
        this.address = address;
        this.city = city;
        this.hobbies = hobbies;
        this.description = description;
        this.url_facebook = url_facebook;
        this.billList = billList;
    }

    public Checker(String name, String dob, Gender gender, String identity, String address, String city, String hobbies, String description, String url_facebook) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
}
