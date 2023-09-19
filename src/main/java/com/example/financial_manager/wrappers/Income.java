package com.example.financial_manager.wrappers;

public class Income {
    private String incomeSource;
    private double incomeAmount;

    public String getIncomeSource() {
        return incomeSource;
    }

    public double getIncomeAmount() {
        return incomeAmount;
    }

    public Income(String incomeSource, double incomeAmount) {
        this.incomeSource = incomeSource;
        this.incomeAmount = incomeAmount;
    }
}
