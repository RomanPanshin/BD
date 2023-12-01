package com.DB.website.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_id")
    private Integer accountId;

    @Column(name = "Account_type")
    private String accountType;

    @Column(name = "Balance", nullable = false)
    private Integer balance;

    @Column(name = "Date_created", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "Customer_id", referencedColumnName = "Customer_id")
    private Customer customer;

    // Getters and setters

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
