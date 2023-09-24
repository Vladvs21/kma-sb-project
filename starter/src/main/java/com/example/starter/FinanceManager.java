package com.example.starter;

import com.example.starter.managers.ExpenseManager;
import com.example.starter.managers.IncomeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class FinanceManager {
    private final ExpenseManager expenseManager;
    private final IncomeManager incomeManager;

    //@Autowired
    public FinanceManager(ExpenseManager expenseManager, IncomeManager incomeManager) {
        this.expenseManager = expenseManager;
        this.incomeManager = incomeManager;
    }

    public double calculateBudget() {
        double totalExpenses = expenseManager.calculateTotalExpenses();
        double totalIncome = incomeManager.calculateTotalIncome();
        return totalIncome - totalExpenses;
    }
}
