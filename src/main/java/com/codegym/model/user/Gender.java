package com.codegym.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genders")
@Data
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Staff.class, mappedBy = "gender")
    @JsonBackReference
    private List<Staff> staffList;

    @OneToMany(targetEntity = Checker.class, mappedBy = "gender")
    @JsonBackReference
    private List<Checker> checkerList;


}
