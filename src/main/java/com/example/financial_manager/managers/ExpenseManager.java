package com.example.financial_manager.managers;

import com.example.financial_manager.entities.Expense;

import java.util.List;

public interface ExpenseManager {
    void addExpense(double amount, String purpose);
    void deleteExpense(Long id);
    void updateExpenseAmount(Long id, double amount);
    void updateExpensePurpose(Long id, String purpose);
    List<Expense> getAllExpenses();
    double calculateTotalExpenses();
}
