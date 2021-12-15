package com.codegym.model.receipt;

import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "interests")
@Data
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "interestGender")
    private List<Checker> checkerList;

    @OneToMany(mappedBy = "interestGender")
    private List<Staff> staffList;


}
