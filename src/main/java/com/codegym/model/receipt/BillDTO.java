package com.codegym.model.receipt;

import javax.persistence.Entity;

public class BillDTO {
    private String id;

    private String dateOrder;

    private String dateEnd;

    private double amount;

    private String staffName;

    private String checkerName;

    private String assessmentContent;

    private String billStatusName;

    public BillDTO(String id, String dateOrder, String dateEnd, double amount, String staffName, String checkerName, String assessmentContent, String billStatusName) {
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

    public BillDTO(String id, String dateOrder, String dateEnd, double amount, String staffName, String checkerName, String billStatusName) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.dateEnd = dateEnd;
        this.amount = amount;
        this.staffName = staffName;
        this.checkerName = checkerName;
        this.billStatusName = billStatusName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
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
