package com.example.starter.managers;

import com.example.starter.wrappers.Expense;

import java.util.List;

public interface ExpenseManager {
    void addExpense(Expense expense);
    List<Expense> getAllExpenses();
    double calculateTotalExpenses();
}
