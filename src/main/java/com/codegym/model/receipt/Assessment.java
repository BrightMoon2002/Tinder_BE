package com.codegym.model.receipt;

import com.codegym.model.account.Account;
import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "assessments")
@Data
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(targetEntity = Checker.class)
//    private Checker owner;
//
//    @ManyToOne(targetEntity = Staff.class)
//    private Staff receiver;

    @OneToOne(targetEntity = Bill.class, mappedBy = "assessment")
    private Bill bill;

    private String content;

    private Integer rate;
}
