package com.codegym.model.user;

import com.codegym.model.receipt.Interest;

import javax.persistence.*;

@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Gender.class)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    private String name;
    private String dob;
    private String city;
    private String nationality;
    private double height;
    private double weight;
    private String description;

    @ManyToOne(targetEntity = Interest.class)
    @JoinColumn(name = "interest_id")
    private Interest interestGender;

    private String avatar;



}
