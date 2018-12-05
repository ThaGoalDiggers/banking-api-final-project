package com.bobby.bankingapifinal.domains;

import javax.persistence.*;

@Entity
public class Withdrawal {
    @Id
    @GeneratedValue
    @Column(name = "WITHDRAWAL_ID")
    private Long id;

    @Column(name = "WITHDRAWAL_TYPE")
    private String type;

    @Column(name = "WITHDRAWAL_DATE")
    private String transactionDate;

    @Column(name = "WITHDRAWAL_STATUS")
    private String status;

    @Column(name = "PAYER_ID")
    private Long payerId;

    @Column(name = "WITHDRAWAL_MEDIUM")
    private String medium;

    @Column(name = "WITHDRAWAL_AMOUNT")
    private Double amount;

    @Column(name = "WITHDRAWAL_DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "WITHDRAWAL_ID")
    private Account account;

    public Withdrawal(Long id, String type, String transactionDate, String status, Long payerId, String medium, Double amount, String description) {
        this.id = id;
        this.type = type;
        this.transactionDate = transactionDate;
        this.status = status;
        this.payerId = payerId;
        this.medium = medium;
        this.amount = amount;
        this.description = description;
    }

    public Withdrawal() {
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

    public Long getPayerId() {
        return payerId;
    }

    public void setPayerId(Long payerId) {
        this.payerId = payerId;
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
        return "Withdrawal{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", status='" + status + '\'' +
                ", payerId=" + payerId +
                ", medium='" + medium + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
