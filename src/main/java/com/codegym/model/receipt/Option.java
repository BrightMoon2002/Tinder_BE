package com.codegym.model.receipt;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "options")
@Data
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @OneToMany(targetEntity = StaffOption.class, mappedBy = "option")
    @JsonBackReference
    private List<StaffOption> staffOptionList;

    @OneToMany(targetEntity = BillOption.class, mappedBy = "option")
    @JsonBackReference
    private List<BillOption> billOptionList;


}
