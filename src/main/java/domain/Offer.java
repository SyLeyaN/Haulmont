package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String userName;

    private String creditName;

    private Date paymentDate;

    private double paymentAll;

    private double paymentMonth;

    private double paymentBody;

    private double paymentPercent;

    public Offer(){

    }

    public Offer(String name, String userName, String creditName, Date paymentDate, double paymentAll, double paymentMonth, double paymentBody, double paymentPercent) {
        this.name = name;
        this.userName = userName;
        this.creditName = creditName;
        this.paymentDate = paymentDate;
        this.paymentAll = paymentAll;
        this.paymentMonth = paymentMonth;
        this.paymentBody = paymentBody;
        this.paymentPercent = paymentPercent;
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

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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
}
