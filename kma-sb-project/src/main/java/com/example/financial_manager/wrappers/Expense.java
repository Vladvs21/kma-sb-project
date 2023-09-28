package com.example.financial_manager.wrappers;

public class Expense {
    private final double expanseAmount;
    private String expensePurpose;
    public Expense(double expanseAmount,String expensePurpose){
        this.expanseAmount = expanseAmount;
        this.expensePurpose = expensePurpose;
    }

    public double getExpanseAmount() {
        return expanseAmount;
    }

    public String getExpensePurpose() {
        return expensePurpose;
    }
}
