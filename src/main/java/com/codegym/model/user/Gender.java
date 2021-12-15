package com.codegym.model.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "genders")
@Data
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private Staff staff;

    @OneToOne
    private Checker checker;


}
