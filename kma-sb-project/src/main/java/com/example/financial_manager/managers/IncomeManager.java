package com.example.financial_manager.managers;

import com.example.financial_manager.wrappers.Income;

import java.util.List;

public interface IncomeManager {
    void addIncome(Income income);
    List<Income> getAllIncomes();
    double calculateTotalIncome();
    void setCurrency(String currency);
    String getCurrency();
}
