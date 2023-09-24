package com.example.starter.managers;

import com.example.starter.wrappers.Investment;

import java.util.List;

public interface InvestmentManager {
    void addInvestment(Investment investment);
    List<Investment> getAllInvestments();
    double calculateTotalInvestments();
}
