package com.bobby.bankingapifinal.domains;
//This domain object was made by Derian


import javax.persistence.*;


@Entity
public class Bill
{



    @Id
    @GeneratedValue
    @Column(name = "bill_id")
    private Long id;

    @Column(name = "bill_status")
    private String status;

    @Column(name = "bill_payee")
    private String payee;

    @Column(name = "bill_nickname")
    private String nickname;

    @Column(name = "bill_creation_date")
    private String creationDate;

    @Column(name = "bill_payment_date")
    private String paymentDate;

    @Column(name = "bill_upcoming_payment_date")
    private String upcomingPaymentDate;

    @Column(name = "bill_recurring_date")
    private Integer recurringDate;

    @Column(name = "bill_payment_amount")
    private Double paymentAmount;

    private Long accountId;

    private Long customerId;


    public Bill(){}

    public Bill(String status, String payee, String nickname,
                String creationDate, String paymentDate, String upcomingPaymentDate,
                Integer recurringDate, Double paymentAmount, Long accountId, Long customerId)
    {
        this.status = status;
        this.payee = payee;
        this.nickname = nickname;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.upcomingPaymentDate = upcomingPaymentDate;
        this.recurringDate = recurringDate;
        this.paymentAmount = paymentAmount;
        this.accountId = accountId;
        this.customerId = customerId;
    }



    public Long getId() { return id; }
    public String getStatus() { return status; }
    public String getPayee() { return payee; }
    public String getNickname() { return nickname; }
    public String getCreationDate() { return creationDate; }
    public String getPaymentDate() { return paymentDate; }
    public String getUpcomingPaymentDate() { return upcomingPaymentDate; }
    public Integer getRecurringDate() { return recurringDate; }
    public Double getPaymentAmount() { return paymentAmount; }
    public Long getAccountId() { return accountId; }
    public Long getCustomerId() { return customerId; }

    public void setStatus(String status) { this.status = status; }
    public void setPayee(String payee) { this.payee = payee; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public void setUpcomingPaymentDate(String upcomingPaymentDate)
    { this.upcomingPaymentDate = upcomingPaymentDate; }

    public void setRecurringDate(Integer recurringDate) { this.recurringDate = recurringDate; }
    public void setPaymentAmount(Double paymentAmount) { this.paymentAmount = paymentAmount; }



    @Override
    public String toString()
    {
        return "Bill{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", payee='" + payee + '\'' +
                ", nickname='" + nickname + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", upcomingPaymentDate='" + upcomingPaymentDate + '\'' +
                ", recurringDate=" + recurringDate +
                ", paymentAmount=" + paymentAmount +
                ", accountId=" + accountId +
                ", customerId=" + customerId +
                '}';
    }



}
