package com.example.financial_manager.entities;

import jakarta.persistence.*;

@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expense_id;
    @Column(nullable = false)
    private double expanseAmount;
    @Column(nullable = false)
    private String expensePurpose;


    public Expense() {
    }
    public void setExpanseAmount(double expanseAmount) {
        this.expanseAmount = expanseAmount;
    }

    public void setExpensePurpose(String expensePurpose) {
        this.expensePurpose = expensePurpose;
    }

    public double getExpanseAmount() {
        return expanseAmount;
    }

    public String getExpensePurpose() {
        return expensePurpose;
    }

    public void setExpense_id(Long expenseId) {
        this.expense_id = expenseId;
    }

    public Long getExpense_id() {
        return expense_id;
    }

    public Expense(Long expense_id,double expanseAmount,String expensePurpose){
        this.expense_id = expense_id;
        this.expanseAmount = expanseAmount;
        this.expensePurpose = expensePurpose;
    }

}
