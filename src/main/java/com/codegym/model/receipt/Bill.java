package com.codegym.model.receipt;

import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bills")
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateOrder;
    private LocalDateTime dateEnd;
    private double amount;
    @ManyToOne(targetEntity = Staff.class)
    private Staff staff;

    @ManyToOne(targetEntity = Checker.class)
    private Checker checker;


    @OneToOne(targetEntity = Assessment.class)
    private Assessment assessment;

    @ManyToOne(targetEntity = BillStatus.class)
    private BillStatus billStatus;

    @OneToMany(targetEntity = BillOption.class, mappedBy = "bill")
    @JsonBackReference
    private List<BillOption> billOptionList;



}
