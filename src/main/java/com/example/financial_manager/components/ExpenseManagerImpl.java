package com.example.financial_manager.components;

import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.wrappers.Expense;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class ExpenseManagerImpl implements ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();


    @Override
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenses;
    }

    @Override
    public double calculateTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getExpanseAmount).sum();
    }
}
