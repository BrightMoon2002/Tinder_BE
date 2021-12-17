package com.codegym.model.receipt;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "options")
@Data
@NoArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @OneToMany(targetEntity = StaffOption.class, mappedBy = "option")
    @JsonIgnore
    private List<StaffOption> staffOptionList;

    @OneToMany(targetEntity = BillOption.class, mappedBy = "option")
    @JsonIgnore
    private List<BillOption> billOptionList;


}
