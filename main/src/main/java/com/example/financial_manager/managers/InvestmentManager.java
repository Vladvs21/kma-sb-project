package com.example.financial_manager.managers;

import com.example.financial_manager.wrappers.Investment;

import java.util.List;

public interface InvestmentManager {
    void addInvestment(Investment investment);
    List<Investment> getAllInvestments();
    double calculateTotalInvestments();
}
