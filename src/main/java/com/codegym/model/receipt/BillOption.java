package com.codegym.model.receipt;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "billOptions")
@Data
public class BillOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Bill.class)
    private Bill bill;

    @ManyToOne(targetEntity = Option.class)

    private Option option;
}
