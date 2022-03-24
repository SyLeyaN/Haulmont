package com.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="userPassport")
    private String userPassport;

    @Column(name="creditName")
    private String creditName;

    @Column(name="paymentAll")
    private double paymentAll;

    @Column(name="paymentMonth")
    private double paymentMonth;

    @Column(name="bankName")
    private String bankName;

    @Column(name="payments")
    @OneToMany
    private List<Payment> payments;

    public Offer(){

    }

    public Offer(String name, String userPassport, String creditName,
                 double paymentAll, String bankName) {
        this.name = name;
        this.userPassport = userPassport;
        this.creditName = creditName;
        this.paymentAll = paymentAll;
        this.bankName = bankName;
        payments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPassport() {
        return userPassport;
    }

    public void setUserPassport(String userPassport) {
        this.userPassport = userPassport;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public double getPaymentAll() {
        return paymentAll;
    }

    public void setPaymentAll(double paymentAll) {
        this.paymentAll = paymentAll;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public double getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(double paymentMonth) {
        this.paymentMonth = paymentMonth;
    }
}
