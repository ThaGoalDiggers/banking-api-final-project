package com.bobby.bankingapifinal.domains;

public class Deposit {
    private Long id;
    private String type;
    private String transactionDate;
    private String status;
    private Long payeeId;
    private String medium;
    private Double amount;
    private String description;

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