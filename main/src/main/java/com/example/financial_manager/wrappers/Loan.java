package com.example.financial_manager.wrappers;

public class Loan {
    private String loanSource;
    private double loanAmount;

    public String getLoanSource() {
        return loanSource;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Loan(String loanSource, double loanSum) {
        this.loanSource = loanSource;
        this.loanAmount = loanSum;
    }
}
