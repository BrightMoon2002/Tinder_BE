package com.codegym.model.user;

import com.codegym.model.account.Account;
import com.codegym.model.receipt.Bill;
import com.codegym.model.receipt.StaffOption;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Gender.class)
    private Gender gender;


    private String name;

    private String dob;

    private String city;


    private String nationality;

    private double height;

    private double weight;

    private String description;


    @OneToMany(targetEntity = Avatar.class, mappedBy = "staff")
    @JsonIgnore
    private List<Avatar> avatarList;

    @OneToMany(targetEntity = Bill.class, mappedBy = "staff")
    @JsonIgnore
    private List<Bill> billList;

    @OneToMany(targetEntity = StaffOption.class, mappedBy = "staff")
    @JsonIgnore
    private List<StaffOption> staffOptionList;

    @OneToOne
    private Account account;

    public Staff() {
    }

    public Staff(Gender gender, String name, String dob, String city, String nationality, double height, double weight, String description, List<Avatar> avatarList, List<Bill> billList, List<StaffOption> staffOptionList, Account account) {
        this.gender = gender;
        this.name = name;
        this.dob = dob;
        this.city = city;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.avatarList = avatarList;
        this.billList = billList;
        this.staffOptionList = staffOptionList;
        this.account = account;
    }

    public Staff(Gender gender, String name, String dob, String city, String nationality, double height, double weight, String description, List<Avatar> avatarList, List<Bill> billList, Account account) {
        this.gender = gender;
        this.name = name;
        this.dob = dob;
        this.city = city;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.avatarList = avatarList;
        this.billList = billList;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Avatar> getAvatarList() {
        return avatarList;
    }

    public void setAvatarList(List<Avatar> avatarList) {
        this.avatarList = avatarList;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public List<StaffOption> getStaffOptionList() {
        return staffOptionList;
    }

    public void setStaffOptionList(List<StaffOption> staffOptionList) {
        this.staffOptionList = staffOptionList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
