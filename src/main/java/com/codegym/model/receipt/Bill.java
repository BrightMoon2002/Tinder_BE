package com.codegym.model.receipt;

import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "bills")
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
    @JsonIgnore
    private List<BillOption> billOptionList;

    public Bill() {
    }

    public Bill(Long id, LocalDateTime dateOrder, LocalDateTime dateEnd, double amount, Staff staff, Checker checker, Assessment assessment, BillStatus billStatus, List<BillOption> billOptionList) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.dateEnd = dateEnd;
        this.amount = amount;
        this.staff = staff;
        this.checker = checker;
        this.assessment = assessment;
        this.billStatus = billStatus;
        this.billOptionList = billOptionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Checker getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public List<BillOption> getBillOptionList() {
        return billOptionList;
    }

    public void setBillOptionList(List<BillOption> billOptionList) {
        this.billOptionList = billOptionList;
    }

    public Bill(LocalDateTime dateOrder, LocalDateTime dateEnd, double amount, Staff staff, Checker checker, BillStatus billStatus) {
        this.dateOrder = dateOrder;
        this.dateEnd = dateEnd;
        this.amount = amount;
        this.staff = staff;
        this.checker = checker;
        this.billStatus = billStatus;
    }

    public Bill(double amount, Staff staff, Checker checker, BillStatus billStatus) {
        this.amount = amount;
        this.staff = staff;
        this.checker = checker;
        this.billStatus = billStatus;
    }

    public Bill(LocalDateTime dateOrder, LocalDateTime dateEnd) {
        this.dateOrder = dateOrder;
        this.dateEnd = dateEnd;
    }
}
