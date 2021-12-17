package com.codegym.model.account;

import com.codegym.model.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
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

    public Status() {
    }

    public Status(Long id, String name, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
    }

    public Status(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public Status(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
