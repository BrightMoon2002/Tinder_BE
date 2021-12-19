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

@Data
@Entity
@Table(name = "staffs")
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Gender.class)
    @NotBlank(message = "cant not blank")
    private Gender gender;

    @NotBlank(message = "cant not blank")
    private String name;
    private String dob;
    @NotBlank(message = "cant not blank")
    private String city;

    @NotBlank(message = "cant not blank")
    private String nationality;
    @NotBlank(message = "Can not blank")
    private double height;
    @NotBlank(message = "cant not blank")
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



}
