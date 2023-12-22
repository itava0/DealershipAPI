package org.pluralsight.model;

import java.time.LocalDate;

public class LeaseContract extends Contract{
    double endingValue,leaseFee,monthlyPayment;

    public LeaseContract(LocalDate date, String customerName, String email, String carSold) {
        super(date, customerName, email, carSold);
    }

    @Override
    double getTotalPrice() {
        return 0;
    }

    @Override
    double getMonthlyPayment() {
        return 0;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }



}