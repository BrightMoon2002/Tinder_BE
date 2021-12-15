package com.codegym.model.user;

import com.codegym.model.receipt.Bill;
import com.codegym.model.receipt.StaffOption;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
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
    @JsonBackReference
    private List<Avatar> avatarList;

    @OneToMany(targetEntity = Avatar.class, mappedBy = "staff")
    @JsonBackReference
    private List<Bill> billList;

    @OneToMany(targetEntity = StaffOption.class, mappedBy = "staff")
    @JsonBackReference
    private List<StaffOption> staffOptionList;



}
