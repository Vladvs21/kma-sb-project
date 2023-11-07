package com.example.financial_manager.managers;

import com.example.financial_manager.dto.ExpenseDto;

import java.util.List;

public interface ExpenseManager {
    ExpenseDto addExpense(ExpenseDto expenseDto);
    void deleteExpense(Long id);
    ExpenseDto updateExpense(Long id,ExpenseDto expenseDto);
    List<ExpenseDto> getAllExpenses();

    ExpenseDto getExpenseById(Long id);
    double calculateTotalExpenses();
}
