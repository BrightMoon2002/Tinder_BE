package com.codegym.model.receipt;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "billStatus")
@Data
public class BillStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Bill.class, mappedBy = "billStatus")
    @JsonBackReference
    private List<Bill> billList;
}
