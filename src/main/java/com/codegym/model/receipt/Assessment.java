package com.codegym.model.receipt;

import com.codegym.model.account.Account;
import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "assessments")
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
    @JsonIgnore
    private Bill bill;

    private String content;

    private Integer rate;

    public Assessment() {
    }

    public Assessment(Long id, Bill bill, String content, Integer rate) {
        this.id = id;
        this.bill = bill;
        this.content = content;
        this.rate = rate;
    }

    public Assessment(Bill bill, String content, Integer rate) {
        this.bill = bill;
        this.content = content;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
