package com.example.starter.managers;

import com.example.starter.wrappers.Loan;

import java.util.List;

public interface LoanManager {
    void addLoan(Loan loan);
    List<Loan> getAllLoans();
    double calculateTotalLoans();
}
