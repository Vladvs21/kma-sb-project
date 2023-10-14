package com.example.financial_manager.managers;

import com.example.financial_manager.entities.Income;

import java.util.List;

public interface IncomeManager {
    void addIncome(double amount, String source);
    void deleteIncome(Long id);
    void updateIncomeAmount(Long id, double amount);
    void updateIncomeSource(Long id, String source);
    List<Income> getAllIncomes();
    double calculateTotalIncome();
}
