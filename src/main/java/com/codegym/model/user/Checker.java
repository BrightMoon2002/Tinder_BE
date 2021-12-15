package com.codegym.model.user;

import com.codegym.model.account.Account;
import com.codegym.model.receipt.Interest;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "checkers")
@Data
public class Checker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "checker")
    private Account account;

    private String name;
    private String dob;
    @ManyToOne(targetEntity = Gender.class)
    @JoinColumn(name = "gender_id")
    private Gender gender;
    private String identity;
    private String address;
    private String city;
    private String hobbies;
    private String description;
    private String url_facebook;

    @ManyToOne(targetEntity =  Interest.class)
    @JoinColumn(name = "interest_id")
    private Interest interestGender;





}
