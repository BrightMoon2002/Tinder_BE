package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Status implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(targetEntity = Account.class, mappedBy = "status", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private List<Account> accounts;


}
