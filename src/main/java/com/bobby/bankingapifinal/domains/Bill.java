package com.bobby.bankingapifinal.domains;



import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



public class Bill
{



    @Id
    @GeneratedValue
    @Column(name = "bill_id")
    private Long id;

    private String accountId;

    private String status, payee, nickname, creationDate, paymentDate, upcomingPaymentDate;
    private Integer recurringDate;
    private Double paymentAmount;



    public Bill(){}

    public Bill(String accountId, String status, String payee, String nickname,
                String creationDate, String paymentDate, String upcomingPaymentDate,
                Integer recurringDate, Double paymentAmount)
    {
        this.accountId = accountId;
        this.status = status;
        this.payee = payee;
        this.nickname = nickname;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.upcomingPaymentDate = upcomingPaymentDate;
        this.recurringDate = recurringDate;
        this.paymentAmount = paymentAmount;
    }



    public Long getId() { return id; }
    public String getAccountId() { return accountId; }
    public String getStatus() { return status; }
    public String getPayee() { return payee; }
    public String getNickname() { return nickname; }
    public String getCreationDate() { return creationDate; }
    public String getPaymentDate() { return paymentDate; }
    public String getUpcomingPaymentDate() { return upcomingPaymentDate; }
    public Integer getRecurringDate() { return recurringDate; }
    public Double getPaymentAmount() { return paymentAmount; }

    public void setStatus(String status) { this.status = status; }
    public void setPayee(String payee) { this.payee = payee; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public void setUpcomingPaymentDate(String upcomingPaymentDate)
    { this.upcomingPaymentDate = upcomingPaymentDate; }

    public void setRecurringDate(Integer recurringDate) { this.recurringDate = recurringDate; }
    public void setPaymentAmount(Double paymentAmount) { this.paymentAmount = paymentAmount; }



}
