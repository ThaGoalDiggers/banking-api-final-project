package com.bobby.bankingapifinal.domains;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
public class Deposit {
    @Id
    @GeneratedValue
    @Column(name = "DEPOSIT_ID")
    private Long id;

    @Column(name = "DEPOSIT_TYPE")
    private String type;

    @Column(name = "DEPOSIT_DATE")
    private String transactionDate;

    @Column(name = "DEPOSIT_STATUS")
    private String status;

    @Column(name = "PAYEE_ID")
    private Long payeeId;

    @Column(name = "DEPOSIT_MEDIUM")
    private String medium;

    @Column(name = "DEPOSIT_AMOUNT")
    private Double amount;

    @Column(name = "DEPOSIT_DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public Deposit(Long id, String type, String transactionDate, String status, Long payeeId, String medium, Double amount, String description) {
        this.id = id;
        this.type = type;
        this.transactionDate = transactionDate;
        this.status = status;
        this.payeeId = payeeId;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
    }

    public Deposit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", status='" + status + '\'' +
                ", payeeId=" + payeeId +
                ", medium='" + medium + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}