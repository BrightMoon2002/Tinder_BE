package com.codegym.model.receipt;

import javax.persistence.Entity;
import java.time.LocalDateTime;

public class BillDTO {
    private Long id;

    private LocalDateTime dateOrder;

    private LocalDateTime dateEnd;

    private double amount;

    private String staffName;

    private String checkerName;

    private String assessmentContent;

    private String billStatusName;

    public BillDTO(Long id, LocalDateTime dateOrder, LocalDateTime dateEnd, double amount, String staffName, String checkerName, String assessmentContent, String billStatusName) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.dateEnd = dateEnd;
        this.amount = amount;
        this.staffName = staffName;
        this.checkerName = checkerName;
        this.assessmentContent = assessmentContent;
        this.billStatusName = billStatusName;
    }

    public BillDTO() {
    }

    public BillDTO(Long id, LocalDateTime dateOrder, LocalDateTime dateEnd, double amount, String staffName, String checkerName, String billStatusName) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.dateEnd = dateEnd;
        this.amount = amount;
        this.staffName = staffName;
        this.checkerName = checkerName;
        this.billStatusName = billStatusName;
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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public String getAssessmentContent() {
        return assessmentContent;
    }

    public void setAssessmentContent(String assessmentContent) {
        this.assessmentContent = assessmentContent;
    }

    public String getBillStatusName() {
        return billStatusName;
    }

    public void setBillStatusName(String billStatusName) {
        this.billStatusName = billStatusName;
    }
}
