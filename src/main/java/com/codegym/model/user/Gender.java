package com.codegym.model.user;

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

    @OneToMany(mappedBy = "gender")
    @JoinColumn(name = "staff_id")
    private List<Staff> staffList;

    @OneToMany(mappedBy = "gender")
    @JoinColumn(name = "checker_id")
    private List<Checker> checkerList;


}
