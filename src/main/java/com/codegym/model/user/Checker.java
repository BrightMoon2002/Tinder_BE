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
@Data
@NoArgsConstructor
public class Checker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JsonIgnore
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











}
