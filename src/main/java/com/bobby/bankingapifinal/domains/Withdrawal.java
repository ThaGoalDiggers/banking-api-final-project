package com.bobby.bankingapifinal.domains;

import com.bobby.bankingapifinal.enumerations.WithdrawalMedium;
import com.bobby.bankingapifinal.enumerations.WithdrawalStatus;
import com.bobby.bankingapifinal.enumerations.WithdrawalType;

import javax.persistence.*;

@Entity
public class Withdrawal {
    @Id
    @GeneratedValue
    @Column(name = "WITHDRAWAL_ID")
    private Long id;

    @Column(name = "WITHDRAWAL_TYPE")
    @Enumerated(EnumType.STRING)
    private WithdrawalType withdrawalType;

    @Column(name = "WITHDRAWAL_DATE")
    private String transactionDate;

    @Column(name = "WITHDRAWAL_STATUS")
    @Enumerated(EnumType.STRING)
    private WithdrawalStatus withdrawalStatus;

    @Column(name = "PAYER_ID")
    private Long payerId;

    @Column(name = "WITHDRAWAL_MEDIUM")
    @Enumerated(EnumType.STRING)
    private WithdrawalMedium withdrawalMedium;

    @Column(name = "WITHDRAWAL_AMOUNT")
    private Double amount;

    @Column(name = "WITHDRAWAL_DESCRIPTION")
    private String description;

    @ManyToOne
    private Account account;

    public Withdrawal(WithdrawalType withdrawalType, String transactionDate, WithdrawalStatus withdrawalStatus, Long payerId, WithdrawalMedium withdrawalMedium, Double amount, String description, Account account) {
        this.withdrawalType = withdrawalType;
        this.transactionDate = transactionDate;
        this.withdrawalStatus = withdrawalStatus;
        this.payerId = payerId;
        this.withdrawalMedium = withdrawalMedium;
        this.amount = amount;
        this.description = description;
        this.account = account;
    }

    public Withdrawal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WithdrawalType getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(WithdrawalType withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public WithdrawalStatus getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(WithdrawalStatus withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
    }

    public WithdrawalMedium getWithdrawalMedium() {
        return withdrawalMedium;
    }

    public void setWithdrawalMedium(WithdrawalMedium withdrawalMedium) {
        this.withdrawalMedium = withdrawalMedium;
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
        return "Withdrawal{" +
                "id=" + id +
                ", withdrawalType=" + withdrawalType +
                ", transactionDate='" + transactionDate + '\'' +
                ", withdrawalStatus=" + withdrawalStatus +
                ", payerId=" + payerId +
                ", withdrawalMedium=" + withdrawalMedium +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", account=" + account +
                '}';
    }
}
