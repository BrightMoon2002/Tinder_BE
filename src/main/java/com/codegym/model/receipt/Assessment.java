package com.codegym.model.receipt;

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

    private Checker owner;

    private Staff receiver;

    private String content;
}
