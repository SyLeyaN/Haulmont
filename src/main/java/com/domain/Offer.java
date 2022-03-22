package com.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="userName")
    private String userName;

    @Column(name="creditName")
    private String creditName;

    @Column(name="paymentData")
    private Date paymentData;

    @Column(name="paymentAll")
    private double paymentAll;

    @Column(name="paymentMonth")
    private double paymentMonth;

    @Column(name="paymentBody")
    private double paymentBody;

    @Column(name="paymentPercent")
    private double paymentPercent;

    @Column(name="bankName")
    private String bankName;

    public Offer(){

    }

    public Offer(String name, String userName, String creditName, Date paymentData,
                 double paymentAll, double paymentMonth, double paymentBody,
                 double paymentPercent, String bankName) {
        this.name = name;
        this.userName = userName;
        this.creditName = creditName;
        this.paymentData = paymentData;
        this.paymentAll = paymentAll;
        this.paymentMonth = paymentMonth;
        this.paymentBody = paymentBody;
        this.paymentPercent = paymentPercent;
        this.bankName = bankName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public Date getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(Date paymentDate) {
        this.paymentData = paymentData;
    }

    public double getPaymentAll() {
        return paymentAll;
    }

    public void setPaymentAll(double paymentAll) {
        this.paymentAll = paymentAll;
    }

    public double getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(double paymentMonth) {
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
