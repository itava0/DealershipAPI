package org.pluralsight.model;

import java.time.LocalDate;

public abstract class Contract {

    protected String customerName,email;
    protected LocalDate date;
    protected String carSold;
    protected double totalPrice,monthlyPayment;
    //constructor

    public Contract(LocalDate date, String customerName, String email, String carSold) {
        this.date = date;
        this.customerName = customerName;
        this.email = email;
        this.carSold = carSold;

    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    abstract double getTotalPrice();
    abstract double getMonthlyPayment();

}
