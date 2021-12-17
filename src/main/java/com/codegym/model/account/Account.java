package com.codegym.model.account;

import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column
    private Double balance;

    @Column
    private String phone;

    @Column
    private String email;

    @ManyToOne(targetEntity = Status.class)
    @JoinColumn
    private Status status;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "accounts_roles",
            joinColumns = {@JoinColumn(name = "accounts_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @OneToOne(mappedBy = "account")
    @JoinColumn(nullable = true)
    private Staff staff;

    @OneToOne(mappedBy = "account")
    private Checker checker;


    public Account(Long id, String username, String password, String fullName, Double balance, String phone, String email, Status status, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.balance = balance;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.roles = roles;
    }

    public Account(String username, String password, String fullName, Double balance, String phone, String email, Status status, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.balance = balance;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.roles = roles;
    }

    public Account(String username, String password, String fullName, Double balance, String phone, String email, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.balance = balance;
        this.phone = phone;
        this.email = email;
        this.roles = roles;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
