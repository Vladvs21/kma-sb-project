package com.example.financial_manager.managers;

import com.example.financial_manager.entities.InvestmentEntity;

import java.util.List;

public interface InvestmentManager {
    void addInvestment(double price, String name);
    void deleteInvestment(Long id);
    void updateInvestmentPrice(Long id, double price);
    void updateInvestmentName(Long id, String name);
    List<InvestmentEntity> getAllInvestments();
    double calculateTotalInvestments();
}
