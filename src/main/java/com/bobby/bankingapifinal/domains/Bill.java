package com.bobby.bankingapifinal.domains;
//This domain object was made by Derian


import com.bobby.bankingapifinal.enumerations.BillStatus;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "BILL_TABLE")
public class Bill
{



    @Id
    @GeneratedValue
    @Column(name = "BILL_ID")
    private Long id;

    @Column(name = "BILL_STATUS")
    @Enumerated(EnumType.STRING)
    private BillStatus status;

    @Column(name = "BILL_PAYEE")
    private String payee;

    @Column(name = "BILL_NICKNAME")
    private String nickname;

    @Column(name = "BILL_CREATION_DATE")
    @NotEmpty
    private String creationDate;

    @Column(name = "BILL_PAYMENT_DATE")
    @NotEmpty
    private String paymentDate;

    @Column(name = "BILL_UPCOMING_PAYMENT_DATE")
    private String upcomingPaymentDate;

    @Column(name = "BILL_RECURRING_DATE")
    private Integer recurringDate;

    @Column(name = "BILL_PAYMENT_AMOUNT")
    private Double paymentAmount;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;



    public Bill(){}

    public Bill(BillStatus status, String payee, String nickname,
                String creationDate, String paymentDate, String upcomingPaymentDate,
                Integer recurringDate, Double paymentAmount, Account account)
    {
        this.status = status;
        this.payee = payee;
        this.nickname = nickname;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.upcomingPaymentDate = upcomingPaymentDate;
        this.recurringDate = recurringDate;
        this.paymentAmount = paymentAmount;
        this.account = account;
    }

    public Bill(BillStatus status, String payee, String nickname,
                String creationDate, String paymentDate, String upcomingPaymentDate,
                Integer recurringDate, Double paymentAmount)
    {
        this.status = status;
        this.payee = payee;
        this.nickname = nickname;
        this.creationDate = creationDate;
        this.paymentDate = paymentDate;
        this.upcomingPaymentDate = upcomingPaymentDate;
        this.recurringDate = recurringDate;
        this.paymentAmount = paymentAmount;
    }

    public Bill(BillStatus status, String payee, String nickname, String upcomingPaymentDate,
                Integer recurringDate, Double paymentAmount)
    {
        this.status = status;
        this.payee = payee;
        this.nickname = nickname;
        this.upcomingPaymentDate = upcomingPaymentDate;
        this.recurringDate = recurringDate;
        this.paymentAmount = paymentAmount;
    }

    public Bill(BillStatus status) { this.status = status; }

    public Bill(String upcomingPaymentDate, Integer recurringDate)
    {
        this.upcomingPaymentDate = upcomingPaymentDate;
        this.recurringDate = recurringDate;
    }



    public Long getId() { return id; }
    public BillStatus getStatus() { return status; }
    public String getPayee() { return payee; }
    public String getNickname() { return nickname; }
    public String getCreationDate() { return creationDate; }
    public String getPaymentDate() { return paymentDate; }
    public String getUpcomingPaymentDate() { return upcomingPaymentDate; }
    public Integer getRecurringDate() { return recurringDate; }
    public Double getPaymentAmount() { return paymentAmount; }
    public Account getAccount() { return account; }


    public void setStatus(BillStatus status) { this.status = status; }
    public void setPayee(String payee) { this.payee = payee; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public void setUpcomingPaymentDate(String upcomingPaymentDate)
    { this.upcomingPaymentDate = upcomingPaymentDate; }

    public void setRecurringDate(Integer recurringDate) { this.recurringDate = recurringDate; }
    public void setPaymentAmount(Double paymentAmount) { this.paymentAmount = paymentAmount; }
    public void setAccount(Account account) { this.account = account; }



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
                ", account=" + account +
                '}';
    }



}
