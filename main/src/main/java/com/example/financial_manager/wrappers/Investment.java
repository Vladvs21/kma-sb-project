package com.example.financial_manager.wrappers;

public class Investment {
    private String investmentName;
    private double investmentPrice;

    public String getInvestmentName() {
        return investmentName;
    }

    public double getInvestmentPrice() {
        return investmentPrice;
    }

    public Investment(String investmentName, double investmentPrice) {
        this.investmentName = investmentName;
        this.investmentPrice = investmentPrice;
    }
}
