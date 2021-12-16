package com.codegym.model.account;

import com.codegym.model.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "status")
public class Status implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(targetEntity = Account.class, mappedBy = "status", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private List<Account> accounts;


}
