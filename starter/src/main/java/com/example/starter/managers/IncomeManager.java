package com.example.starter.managers;

import com.example.starter.wrappers.Income;

import java.util.List;

public interface IncomeManager {
    void addIncome(Income income);
    List<Income> getAllIncomes();
    double calculateTotalIncome();
}
