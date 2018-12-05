package com.bobby.bankingapifinal.domains;

import com.bobby.bankingapifinal.enumerations.DepositMedium;
import com.bobby.bankingapifinal.enumerations.DepositStatus;
import com.bobby.bankingapifinal.enumerations.DepositType;
import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
public class Deposit {
    @Id
    @GeneratedValue
    @Column(name = "DEPOSIT_ID")
    private Long id;

    @Column(name = "DEPOSIT_TYPE")
    @Enumerated(EnumType.STRING)
    private DepositType depositType;

    @Column(name = "DEPOSIT_DATE")
    private String transactionDate;

    @Column(name = "DEPOSIT_STATUS")
    @Enumerated(EnumType.STRING)
    private DepositStatus depositStatus;

    @Column(name = "PAYEE_ID")
    private Long payeeId;

    @Column(name = "DEPOSIT_MEDIUM")
    @Enumerated(EnumType.STRING)
    private DepositMedium depositMedium;

    @Column(name = "DEPOSIT_AMOUNT")
    private Double amount;

    @Column(name = "DEPOSIT_DESCRIPTION")
    private String description;

    @ManyToOne
    private Account account;

    public Deposit(DepositType depositType, String transactionDate, DepositStatus depositStatus, Long payeeId, DepositMedium depositMedium, Double amount, String description, Account account) {
        this.depositType = depositType;
        this.transactionDate = transactionDate;
        this.depositStatus = depositStatus;
        this.payeeId = payeeId;
        this.depositMedium = depositMedium;
        this.amount = amount;
        this.description = description;
        this.account = account;
    }

    public Deposit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public DepositStatus getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(DepositStatus depositStatus) {
        this.depositStatus = depositStatus;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public DepositMedium getDepositMedium() {
        return depositMedium;
    }

    public void setDepositMedium(DepositMedium depositMedium) {
        this.depositMedium = depositMedium;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", depositType=" + depositType +
                ", transactionDate='" + transactionDate + '\'' +
                ", depositStatus=" + depositStatus +
                ", payeeId=" + payeeId +
                ", depositMedium=" + depositMedium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", account=" + account +
                '}';
    }
}