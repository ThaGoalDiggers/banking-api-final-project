package com.bobby.bankingapifinal.domains;
//This domain object was made by Derian


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
public class Bill
{



    @Id
    @GeneratedValue
    @Column(name = "bill_id")
    private Long id;

    @Column(name = "bill_status")
    @NotEmpty
    private String status;

    @Column(name = "bill_payee")
    private String payee;

    @Column(name = "bill_nickname")
    private String nickname;

    @Column(name = "bill_creation_date")
    @NotEmpty
    private String creationDate;

    @Column(name = "bill_payment_date")
    @NotEmpty
    private String paymentDate;

    @Column(name = "bill_upcoming_payment_date")
    private String upcomingPaymentDate;

    @Column(name = "bill_recurring_date")
    private Integer recurringDate;

    @Column(name = "bill_payment_amount")
    private Double paymentAmount;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;



    public Bill(){}

    public Bill(String status, String payee, String nickname,
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
        this.customer = account.getCustomer();
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
    public Account getAccount() { return account; }
    public Customer getCustomer() { return customer; }


    public void setStatus(String status) { this.status = status; }
    public void setPayee(String payee) { this.payee = payee; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public void setUpcomingPaymentDate(String upcomingPaymentDate)
    { this.upcomingPaymentDate = upcomingPaymentDate; }

    public void setRecurringDate(Integer recurringDate) { this.recurringDate = recurringDate; }
    public void setPaymentAmount(Double paymentAmount) { this.paymentAmount = paymentAmount; }



    @Override
    public String toString() {
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
