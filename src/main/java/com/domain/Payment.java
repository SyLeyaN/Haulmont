package com.domain;

import javax.persistence.*;

@Entity
@Table(name="Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="month")
    private int month;

    @Column(name="name")
    private String name;

    @Column(name="paymentMonth")
    private double paymentMonth;

    @Column(name="paymentBody")
    private double paymentBody;

    @Column(name="paymentPercent")
    private double paymentPercent;

    @Column(name="balance")
    private double balance;

    public Payment(){

    }

    public Payment(String name,int month, double paymentMonth, double paymentBody, double paymentPercent,double balance) {
        this.name=name;
        this.month = month;
        this.paymentMonth = paymentMonth;
        this.paymentBody = paymentBody;
        this.paymentPercent = paymentPercent;
        this.balance=balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentAll(double paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public double getPaymentBody() {
        return paymentBody;
    }

    public void setPaymentBody(double paymentBody) {
        this.paymentBody = paymentBody;
    }

    public double getPaymentPercent() {
        return paymentPercent;
    }

    public void setPaymentPercent(double paymentPercent) {
        this.paymentPercent = paymentPercent;
    }

    public void setPaymentMonth(double paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
