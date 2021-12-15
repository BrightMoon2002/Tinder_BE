package com.codegym.model.receipt;

import com.codegym.model.user.Staff;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    @OneToOne(targetEntity = Staff.class)
    private Staff staff;

}
