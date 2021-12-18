package com.codegym.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genders")
@Data
@NoArgsConstructor
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Staff.class, mappedBy = "gender",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Staff> staffList;

    @OneToMany(targetEntity = Checker.class, mappedBy = "gender",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Checker> checkerList;


}
