package com.example.financial_manager.managers;

import com.example.financial_manager.wrappers.Expense;

import java.util.List;

public interface ExpenseManager {
    void addExpense(Expense expense);
    List<Expense> getAllExpenses();
    double calculateTotalExpenses();
}
