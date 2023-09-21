package com.example.financial_manager.managers;

import com.example.financial_manager.wrappers.Loan;

import java.util.List;

public interface LoanManager {
    void addLoan(Loan loan);
    List<Loan> getAllLoans();
    double calculateTotalLoans();
}
