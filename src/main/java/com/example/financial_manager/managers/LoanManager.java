package com.example.financial_manager.managers;

import com.example.financial_manager.entities.Loan;

import java.util.List;

public interface LoanManager {
    void addLoan(double amount, String source);
    void deleteLoan(Long id);
    void updateLoanAmount(Long id, double amount);
    void updateLoanSource(Long id, String source);
    List<Loan> getAllLoans();
    double calculateTotalLoans();
}
