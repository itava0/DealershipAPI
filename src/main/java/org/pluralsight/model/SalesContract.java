package org.pluralsight.model;

import java.time.LocalDate;

public class SalesContract extends Contract{

    private double salesTax = .05;
    private double recordingFee = 100;
    private double processingFee;
    private boolean finance;
    private double monthlyPayment;


    public SalesContract(LocalDate date, String customerName, String email, String carSold, boolean finance) {
        super(date, customerName, email, carSold);
        this.finance = finance;

    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    double getTotalPrice() {
        return 0;
    }

    @Override
    double getMonthlyPayment() {
        return 0;
    }

}
